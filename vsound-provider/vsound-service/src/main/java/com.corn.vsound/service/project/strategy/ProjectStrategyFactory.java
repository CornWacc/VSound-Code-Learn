package com.corn.vsound.service.project.strategy;

import com.corn.vsound.common.spring.SpringBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectStrategyFactory {

    private static final String CREATE = "CREATE";

    private static final String UPDATE = "UPDATE";

    private static final String DELETE = "DELETE";

    @Autowired
    private SpringBeanUtils springBeanUtils;

    public ProjectStrategyInterface createProjectStrategy(String cudType){

        ProjectStrategyInterface projectCreateStrategy = null;
        if(CREATE.equals(cudType)){
            projectCreateStrategy = springBeanUtils.getApplicationContext().getBean(ProjectCreateStrategy.class);
        }

        if(UPDATE.equals(cudType)){
            projectCreateStrategy = springBeanUtils.getApplicationContext().getBean(ProjectUpdateStrategy.class);
        }

        if(DELETE.equals(cudType)){
            projectCreateStrategy = springBeanUtils.getApplicationContext().getBean(ProjectDelStrategy.class);
        }

        return projectCreateStrategy;
    }

}
