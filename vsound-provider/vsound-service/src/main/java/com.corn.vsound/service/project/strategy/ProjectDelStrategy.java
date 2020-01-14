package com.corn.vsound.service.project.strategy;

import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.entity.CodeBase;
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
                //todo 还需要清除掉对应源码的扩展参数
                codeBaseMapper.deleteCodesByCodeIds(codeIds);
                codeMethodMapper.deleteCodeMethodsByCodeIds(codeIds);
                codeParameterMapper.deleteCodeParametersByCodeIds(codeIds);
                codeOutSideUrlMapper.deleteCodeOutSideUrlsByCodeIds(codeIds);
            }
        }
        return new ProjectCUDResult();
    }
}
