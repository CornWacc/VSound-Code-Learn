package com.corn.vsound.project.delegate;

import com.corn.boot.annotations.DoTranscation;
import com.corn.boot.base.AbstractBizService;
import com.corn.boot.util.AppUtils;
import com.corn.vsound.dao.entity.ProjectBase;
import com.corn.vsound.dao.mapper.ProjectBaseMapper;
import com.corn.vsound.project.create.ProjectAddOrder;
import com.corn.vsound.project.create.ProjectAddResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@DoTranscation
public class ProjectAddDelegate extends AbstractBizService<ProjectAddOrder, ProjectAddResult> {

    @Autowired
    private ProjectBaseMapper projectBaseMapper;

    @Override
    protected ProjectAddResult initResult() {
        return new ProjectAddResult();
    }

    @Override
    protected void orderCheck(ProjectAddOrder order) {
        order.orderCheck();
    }

    @Override
    protected void appBiz(ProjectAddOrder order, ProjectAddResult result) {

        ProjectBase projectBase = new ProjectBase();
        BeanUtils.copyProperties(order,projectBase);
        projectBase.setCreateTime(new Date());
        projectBase.setProjectId(AppUtils.correspondingCreate("pr"));

        projectBaseMapper.insertSelective(projectBase);
    }
}
