package com.corn.vsound.facade.project;


import com.corn.vsound.facade.project.order.ProjectCUDOrder;
import com.corn.vsound.facade.project.order.ProjectListQueryOrder;
import com.corn.vsound.facade.project.order.ProjectQueryOrder;
import com.corn.vsound.facade.project.result.ProjectCUDResult;
import com.corn.vsound.facade.project.result.ProjectListQueryResult;
import com.corn.vsound.facade.project.result.ProjectQueryResult;

/**
 * @author yyc
 * @apiNote 项目外部接口
 * */
public interface ProjectFacade {

    ProjectListQueryResult projectListQuery(ProjectListQueryOrder order);

    ProjectCUDResult projectCUD(ProjectCUDOrder order);

    ProjectQueryResult projectQuery(ProjectQueryOrder order);

}
