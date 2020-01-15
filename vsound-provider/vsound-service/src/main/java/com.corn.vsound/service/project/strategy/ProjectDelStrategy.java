package com.corn.vsound.service.project.strategy;

import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.entity.CodeBase;
import com.corn.vsound.dao.entity.CodeMethod;
import com.corn.vsound.dao.entity.ProjectBase;
import com.corn.vsound.dao.mapper.*;
import com.corn.vsound.facade.project.order.ProjectCUDOrder;
import com.corn.vsound.facade.project.result.ProjectCUDResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectDelStrategy implements CudExecuteInterface<ProjectCUDOrder, ProjectCUDResult> {

    @Autowired
    private ProjectBaseMapper projectBaseMapper;

    @Autowired
    private CodeBaseMapper codeBaseMapper;

    @Autowired
    private CodeMethodMapper codeMethodMapper;

    @Autowired
    private CodeParameterMapper codeParameterMapper;

    @Autowired
    private CodeOutSideUrlMapper codeOutSideUrlMapper;

    @Autowired
    private CodeMethodOrderMapper codeMethodOrderMapper;


    @Override
    public ProjectCUDResult execute(ProjectCUDOrder order) {

        ProjectBase projectBase = projectBaseMapper.findProjectBaseByProjectId(order.getProjectId());
        if(ObjectUtils.isEmpty(projectBase)){
            throw new BizError("该项目不存在！请刷新页面!");
        }

        projectBaseMapper.deleteByPrimaryKey(order.getProjectId());

        List<CodeBase> codeBaseList = codeBaseMapper.pageFindCodeBaseListByProjectIdOrKeyWord(projectBase.getProjectId(),null,null);
        if(!ObjectUtils.isEmpty(codeBaseList)){
            List<String> codeIds = codeBaseList.stream().map(CodeBase::getCodeId).collect(Collectors.toList());

            if (!ObjectUtils.isEmpty(codeIds)) {
                codeBaseMapper.deleteCodesByCodeIds(codeIds);
                codeMethodMapper.deleteCodeMethodsByCodeIds(codeIds);
                // 删除方法对应的所有参数
                List<CodeMethod> codeMethods = codeMethodMapper.findCodeMethodListByCodeId(codeIds);
                if(!ObjectUtils.isEmpty(codeMethods)){
                    List<String> methodIds = codeMethods.stream().map(CodeMethod::getMethodId).collect(Collectors.toList());
                    codeMethodOrderMapper.batchDeleteMethodOrder(methodIds);
                }

                codeParameterMapper.deleteCodeParametersByCodeIds(codeIds);
                codeOutSideUrlMapper.deleteCodeOutSideUrlsByCodeIds(codeIds);
            }
        }
        return new ProjectCUDResult();
    }
}
