package com.corn.vsound.project;


import com.corn.vsound.project.create.ProjectAddOrder;
import com.corn.vsound.project.create.ProjectAddResult;
import com.corn.vsound.project.list.ProjectListQueryOrder;
import com.corn.vsound.project.list.ProjectListQueryResult;

/**
 * @author yyc
 * @apiNote 项目服务接口
 * */
public interface ProjectFacade {

    ProjectListQueryResult projectListQuery(ProjectListQueryOrder order);

    ProjectAddResult projectAdd(ProjectAddOrder order);
}
