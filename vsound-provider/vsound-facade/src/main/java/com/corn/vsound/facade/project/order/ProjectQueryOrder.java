package com.corn.vsound.facade.project.order;

import com.corn.boot.base.page.PageOrder;
import com.corn.boot.base.pojobase.BaseOrder;

/**
 * @author yyc
 */
public class ProjectQueryOrder extends PageOrder {

    private String projectId;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
