package com.corn.vsound.project.create;

import com.corn.boot.base.BaseOrder;

/**
 * @author yyc
 * @apiNote 项目新增入参
 * */
public class ProjectAddOrder extends BaseOrder {
    private static final long serialVersionUID = -4968289639998032039L;

    private String projectName;

    private String projectType;

    private String projectAffiliation;

    private String usePosition;

    private String remark;

    private String createUserId;

    private String createUserName;

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectAffiliation() {
        return projectAffiliation;
    }

    public void setProjectAffiliation(String projectAffiliation) {
        this.projectAffiliation = projectAffiliation;
    }

    public String getUsePosition() {
        return usePosition;
    }

    public void setUsePosition(String usePosition) {
        this.usePosition = usePosition;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
