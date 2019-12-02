package com.corn.vsound.service.project.strategy;

import com.corn.vsound.dao.mapper.ProjectBaseMapper;
import com.corn.vsound.facade.project.order.ProjectCUDOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectUpdateStrategy implements ProjectStrategyInterface {

    @Autowired
    private ProjectBaseMapper projectBaseMapper;

    @Override
    public void execute(ProjectCUDOrder order) {

    }
}
