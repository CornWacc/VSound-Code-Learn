package com.corn.vsound.service.project;

import com.corn.vsound.facade.project.ProjectFacade;
import com.corn.vsound.facade.project.order.ProjectCUDOrder;
import com.corn.vsound.facade.project.order.ProjectListQueryOrder;
import com.corn.vsound.facade.project.order.ProjectQueryOrder;
import com.corn.vsound.facade.project.result.ProjectCUDResult;
import com.corn.vsound.facade.project.result.ProjectListQueryResult;
import com.corn.vsound.facade.project.result.ProjectQueryResult;
import com.corn.vsound.service.project.delegate.ProjectCUDDelegate;
import com.corn.vsound.service.project.delegate.ProjectListQueryDelegate;
import com.corn.vsound.service.project.delegate.ProjectQueryDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectFacadeImpl implements ProjectFacade {

    @Autowired
    private ProjectListQueryDelegate projectListQueryDelegate;

    @Autowired
    private ProjectCUDDelegate projectCUDDelegate;

    @Autowired
    private ProjectQueryDelegate projectQueryDelegate;

    @Override
    public ProjectListQueryResult projectListQuery(ProjectListQueryOrder order) {
        return projectListQueryDelegate.execute("项目列表查询",order);
    }

    @Override
    public ProjectCUDResult projectCUD(ProjectCUDOrder order) {
        return projectCUDDelegate.execute("项目增删改业务",order);
    }

    @Override
    public ProjectQueryResult projectQuery(ProjectQueryOrder order) {
        return projectQueryDelegate.execute("单项目查询",order);
    }
}
