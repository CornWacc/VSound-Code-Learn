package com.corn.vsound.integration.projcet;

import com.corn.boot.annotations.Log;
import com.corn.vsound.facade.project.ProjectFacade;
import com.corn.vsound.facade.project.order.ProjectCUDOrder;
import com.corn.vsound.facade.project.order.ProjectListQueryOrder;
import com.corn.vsound.facade.project.result.ProjectCUDResult;
import com.corn.vsound.facade.project.result.ProjectListQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectFacadeClientImpl implements ProjectFacadeClient{

    @Autowired
    private ProjectFacade projectFacade;

    @Override
    @Log(name = "项目服务",des = "项目列表查询")
    public ProjectListQueryResult projectListQuery(ProjectListQueryOrder order) {
        return projectFacade.projectListQuery(order);
    }

    @Override
    @Log(name = "项目服务",des = "项目增删改业务")
    public ProjectCUDResult projectCUD(ProjectCUDOrder order) {
        return projectFacade.projectCUD(order);
    }
}
