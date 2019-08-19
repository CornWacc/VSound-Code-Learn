package com.corn.vsound.project;


import com.corn.vsound.project.create.ProjectAddOrder;
import com.corn.vsound.project.create.ProjectAddResult;
import com.corn.vsound.project.delegate.ProjectAddDelegate;
import com.corn.vsound.project.delegate.ProjectListQueryDelegate;
import com.corn.vsound.project.list.ProjectListQueryOrder;
import com.corn.vsound.project.list.ProjectListQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectFacadeImpl implements ProjectFacade{

    @Autowired
    private ProjectListQueryDelegate projectListQueryDelegate;

    @Autowired
    private ProjectAddDelegate projectAddDelegate;

    @Override
    public ProjectListQueryResult projectListQuery(ProjectListQueryOrder order) {
        return projectListQueryDelegate.execute("项目列表查询",order);
    }

    @Override
    public ProjectAddResult projectAdd(ProjectAddOrder order) {
        return projectAddDelegate.execute("源码项目新增",order);
    }
}
