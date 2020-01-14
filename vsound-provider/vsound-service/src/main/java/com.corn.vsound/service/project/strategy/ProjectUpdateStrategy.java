package com.corn.vsound.service.project.strategy;

import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.entity.ProjectBase;
import com.corn.vsound.dao.mapper.ProjectBaseMapper;
import com.corn.vsound.facade.project.order.ProjectCUDOrder;
import com.corn.vsound.facade.project.result.ProjectCUDResult;
import com.google.common.base.Optional;
import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.Op;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class ProjectUpdateStrategy implements CudExecuteInterface<ProjectCUDOrder, ProjectCUDResult> {

    @Autowired
    private ProjectBaseMapper projectBaseMapper;

    @Override
    public ProjectCUDResult execute(ProjectCUDOrder order) {

        ProjectBase projectBase = projectBaseMapper.findProjectBaseByProjectId(order.getProjectId());

        if(ObjectUtils.isEmpty(projectBase)){
            throw new BizError("需更新的项目不存在，请刷新页面");
        }

        BeanCopier.create(ProjectCUDOrder.class,ProjectBase.class,false).copy(order,projectBase,null);
        projectBaseMapper.updateByPrimaryKeySelective(projectBase);
        return new ProjectCUDResult();
    }
}
