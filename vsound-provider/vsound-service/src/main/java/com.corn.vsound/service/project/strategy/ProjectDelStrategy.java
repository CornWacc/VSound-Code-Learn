package com.corn.vsound.service.project.strategy;

import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.entity.ProjectBase;
import com.corn.vsound.dao.mapper.ProjectBaseMapper;
import com.corn.vsound.facade.project.order.ProjectCUDOrder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class ProjectDelStrategy implements BaseCUDInterface<ProjectCUDOrder> {

    @Autowired
    private ProjectBaseMapper projectBaseMapper;

    @Override
    public void execute(ProjectCUDOrder order) {

        if(StringUtils.isBlank(order.getProjectId())){
            throw new BizError("需删除的项目Id不能为空");
        }

        ProjectBase projectBase = projectBaseMapper.findProjectBaseByProjectId(order.getProjectId());
        if(ObjectUtils.isEmpty(projectBase)){
            throw new BizError("该项目不存在！请刷新页面!");
        }

        projectBaseMapper.deleteByPrimaryKey(order.getProjectId());
    }
}
