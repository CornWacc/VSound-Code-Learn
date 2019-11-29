package com.corn.vsound.facade.project.result;

import com.corn.boot.base.pojobase.BaseRes;
import com.corn.vsound.facade.project.info.ProjectInfo;

import java.util.List;

/**
 * @author yyc
 */
public class ProjectListQueryResult extends BaseRes {

    private static final long serialVersionUID = -6688802313278191154L;

    private List<ProjectInfo> projectInfoList;

    public List<ProjectInfo> getProjectInfoList() {
        return projectInfoList;
    }

    public void setProjectInfoList(List<ProjectInfo> projectInfoList) {
        this.projectInfoList = projectInfoList;
    }
}
