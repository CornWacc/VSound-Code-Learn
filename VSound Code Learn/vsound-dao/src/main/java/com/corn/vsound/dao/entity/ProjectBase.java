package com.corn.vsound.dao.entity;

import java.util.Date;

public class ProjectBase {
    private Integer id;

    private String projectId;

    private String projectName;

    private String projectAffiliation;

    private String projectType;

    private String usePosition;

    private String remark;

    private Integer gatherClassCount;

    private Integer gatherInterfaceCount;

    private String createUserId;

    private String createUserName;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectAffiliation() {
        return projectAffiliation;
    }

    public void setProjectAffiliation(String projectAffiliation) {
        this.projectAffiliation = projectAffiliation == null ? null : projectAffiliation.trim();
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType == null ? null : projectType.trim();
    }

    public String getUsePosition() {
        return usePosition;
    }

    public void setUsePosition(String usePosition) {
        this.usePosition = usePosition == null ? null : usePosition.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}