package com.corn.vsound.service.project;

import com.corn.vsound.facade.project.ProjectFacade;
import com.corn.vsound.facade.project.order.ProjectListQueryOrder;
import com.corn.vsound.facade.project.result.ProjectListQueryResult;
import com.corn.vsound.service.project.delegate.ProjectListQueryDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectFacadeImpl implements ProjectFacade {

    @Autowired
    private ProjectListQueryDelegate projectListQueryDelegate;

    @Override
    public ProjectListQueryResult projectListQuery(ProjectListQueryOrder order) {
        return projectListQueryDelegate.execute("项目列表查询",order);
    }
}
