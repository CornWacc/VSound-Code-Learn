package com.corn.vsound.service.project.strategy;

import com.corn.boot.util.DateUtils;
import com.corn.vsound.dao.entity.ProjectBase;
import com.corn.vsound.dao.mapper.ProjectBaseMapper;
import com.corn.vsound.facade.project.order.ProjectCUDOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProjectCreateStrategy implements ProjectStrategyInterface {

    @Autowired
    private ProjectBaseMapper projectBaseMapper;

    @Override
    public void execute(ProjectCUDOrder order) {

        ProjectBase projectBase = new ProjectBase();
        BeanCopier.create(ProjectCUDOrder.class, ProjectBase.class,false).copy(order,projectBase,null);
        projectBase.setProjectId("pr"+ DateUtils.dateForMateForConnect(new Date()));

        projectBaseMapper.insertSelective(projectBase);
    }
}
