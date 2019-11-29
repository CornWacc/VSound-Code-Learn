package com.corn.vsound.facade.project.info;

import com.corn.boot.base.pojobase.Base;

/**
 * @author yyc
 */
public class ProjectInfo extends Base {

    private static final long serialVersionUID = -6612409904223379905L;

    private String projectName;

    private String projectId;

    private String projectAffilitaion;

    private String projectType;

    private String usePosition;

    private String remark;

    private Integer gatherClassCount;

    private Integer gatherInterfaceCount;

    private String createUserId;

    private String createUserName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectAffilitaion() {
        return projectAffilitaion;
    }

    public void setProjectAffilitaion(String projectAffilitaion) {
        this.projectAffilitaion = projectAffilitaion;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
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

    public Integer getGatherClassCount() {
        return gatherClassCount;
    }

    public void setGatherClassCount(Integer gatherClassCount) {
        this.gatherClassCount = gatherClassCount;
    }

    public Integer getGatherInterfaceCount() {
        return gatherInterfaceCount;
    }

    public void setGatherInterfaceCount(Integer gatherInterfaceCount) {
        this.gatherInterfaceCount = gatherInterfaceCount;
    }

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
}
