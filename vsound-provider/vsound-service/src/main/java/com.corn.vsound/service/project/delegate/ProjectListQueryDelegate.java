package com.corn.vsound.service.project.delegate;

import com.corn.boot.base.AbstractBizService;
import com.corn.vsound.dao.entity.ProjectBase;
import com.corn.vsound.dao.mapper.ProjectBaseMapper;
import com.corn.vsound.facade.project.info.ProjectInfo;
import com.corn.vsound.facade.project.order.ProjectListQueryOrder;
import com.corn.vsound.facade.project.result.ProjectListQueryResult;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import sun.misc.ProxyGenerator;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProjectListQueryDelegate extends AbstractBizService<ProjectListQueryOrder, ProjectListQueryResult> {

    @Autowired
    private ProjectBaseMapper projectBaseMapper;

    @Override
    protected ProjectListQueryResult initResult() {
        return new ProjectListQueryResult();
    }

    @Override
    protected void orderCheck(ProjectListQueryOrder order) {
        order.orderCheck();
    }

    @Override
    protected void appBiz(ProjectListQueryOrder order, ProjectListQueryResult result) {

        List<ProjectBase> projectInfoList = projectBaseMapper.findProjectListByKeyWord(order.getKeyWord());
        if(!ObjectUtils.isEmpty(projectInfoList)){

            List<ProjectInfo> infos = Lists.newArrayListWithCapacity(10);
            for(ProjectBase projectBase : projectInfoList){
                ProjectInfo projectInfo = new ProjectInfo();
                BeanCopier.create(ProjectBase.class,ProjectInfo.class,false).copy(projectBase,projectInfo,null);
                infos.add(projectInfo);
            }
            result.setProjectInfoList(infos);
        }else{
            result.setProjectInfoList(new ArrayList<>());
        }
    }
}
