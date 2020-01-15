package com.corn.vsound.service.project.delegate;

import com.corn.boot.base.AbstractBizService;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.entity.CodeBase;
import com.corn.vsound.dao.entity.ProjectBase;
import com.corn.vsound.dao.mapper.CodeBaseMapper;
import com.corn.vsound.dao.mapper.ProjectBaseMapper;
import com.corn.vsound.facade.code.info.CodeInfo;
import com.corn.vsound.facade.project.order.ProjectQueryOrder;
import com.corn.vsound.facade.project.result.ProjectQueryResult;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProjectQueryDelegate extends AbstractBizService<ProjectQueryOrder, ProjectQueryResult> {

    @Autowired
    private ProjectBaseMapper projectBaseMapper;

    @Autowired
    private CodeBaseMapper codeBaseMapper;

    @Override
    protected ProjectQueryResult initResult() {
        return new ProjectQueryResult();
    }

    @Override
    protected void orderCheck(ProjectQueryOrder order) {
        order.orderCheck();
        if(StringUtils.isBlank(order.getProjectId())){
            throw new BizError("查询的项目Id不能为空!请核实！");
        }
    }

    @Override
    protected void appBiz(ProjectQueryOrder order, ProjectQueryResult result) {

        ProjectBase projectBase = projectBaseMapper.findProjectBaseByProjectId(order.getProjectId());
        if(ObjectUtils.isEmpty(projectBase)){
           throw new BizError("查询的项目不存在！请刷新页面");
        }
        BeanCopier.create(ProjectBase.class,ProjectQueryResult.class,false).copy(projectBase,result,null);

        if(!ObjectUtils.isEmpty(order.getPageParamInfo())){
            PageHelper.startPage(order.getPageParamInfo().getPageNum(),order.getPageParamInfo().getPageSize());
        }


        List<CodeBase> codeBaseList = codeBaseMapper.pageFindCodeBaseListByProjectIdOrKeyWord(projectBase.getProjectId(),order.getKeyWord(),!ObjectUtils.isEmpty(order.getCodeType())? order.getCodeType().getCode() : null);
        if(ObjectUtils.isEmpty(codeBaseList)){
            result.setCodeInfoList(new ArrayList<>());
        }

        List<CodeInfo> codeInfos = new ArrayList<>();
        for(CodeBase codeBase : codeBaseList){
            CodeInfo codeInfo = new CodeInfo();
            BeanCopier.create(CodeBase.class,CodeInfo.class,false).copy(codeBase,codeInfo,null);
            codeInfos.add(codeInfo);
        }
        result.setCodeInfoList(codeInfos);

    }
}
