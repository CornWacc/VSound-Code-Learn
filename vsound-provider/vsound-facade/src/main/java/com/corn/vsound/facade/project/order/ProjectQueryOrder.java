package com.corn.vsound.facade.project.order;

import com.corn.boot.base.page.PageOrder;
import com.corn.boot.base.pojobase.BaseOrder;
import com.corn.vsound.facade.enums.ClassTypeEnum;

/**
 * @author yyc
 */
public class ProjectQueryOrder extends PageOrder {

    private String projectId;

    private ClassTypeEnum codeType;

    public ClassTypeEnum getCodeType() {
        return codeType;
    }

    public void setCodeType(ClassTypeEnum codeType) {
        this.codeType = codeType;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
