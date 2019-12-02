package com.corn.vsound.integration.projcet;

import com.corn.vsound.facade.project.order.ProjectCUDOrder;
import com.corn.vsound.facade.project.order.ProjectListQueryOrder;
import com.corn.vsound.facade.project.result.ProjectCUDResult;
import com.corn.vsound.facade.project.result.ProjectListQueryResult;

public interface ProjectFacadeClient {

    ProjectListQueryResult projectListQuery(ProjectListQueryOrder order);

    ProjectCUDResult projectCUD(ProjectCUDOrder order);

}
