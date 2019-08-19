package com.corn.vsound.project.list;

import com.corn.boot.base.BaseRes;
import com.corn.vsound.project.info.ProjectInfo;

import java.util.List;

/**
 * @author yyc
 * @apiNote 项目列表查询出参
 * */
public class ProjectListQueryResult extends BaseRes {
    private static final long serialVersionUID = 3226362498107493304L;

    private List<ProjectInfo> projectInfoList;

    public List<ProjectInfo> getProjectInfoList() {
        return projectInfoList;
    }

    public void setProjectInfoList(List<ProjectInfo> projectInfoList) {
        this.projectInfoList = projectInfoList;
    }
}
