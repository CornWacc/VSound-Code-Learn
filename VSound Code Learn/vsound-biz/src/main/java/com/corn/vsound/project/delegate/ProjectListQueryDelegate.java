package com.corn.vsound.project.delegate;

import com.corn.boot.base.AbstractBizService;
import com.corn.vsound.dao.entity.ProjectBase;
import com.corn.vsound.dao.mapper.ProjectBaseMapper;
import com.corn.vsound.project.info.ProjectInfo;
import com.corn.vsound.project.list.ProjectListQueryOrder;
import com.corn.vsound.project.list.ProjectListQueryResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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

        List<ProjectBase> projectBaseList = projectBaseMapper.findProjectListByKeyWord(order.getKeyWord());
        if(!ObjectUtils.isEmpty(projectBaseList)){
            List<ProjectInfo> projectInfos = new ArrayList<>();
            for(ProjectBase projectBase : projectBaseList){
                ProjectInfo info = new ProjectInfo();
                BeanUtils.copyProperties(projectBase,info);
                projectInfos.add(info);
            }
            result.setProjectInfoList(projectInfos);
        }else{
            result.setProjectInfoList(new ArrayList<>());
        }
    }
}
