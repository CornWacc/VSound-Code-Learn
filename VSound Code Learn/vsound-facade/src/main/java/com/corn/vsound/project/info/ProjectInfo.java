package com.corn.vsound.project.info;

import com.corn.boot.base.Base;

import java.util.Date;


/**
 * @author yyc
 * @apiNote 项目实体
 * */
public class ProjectInfo extends Base {
    private static final long serialVersionUID = -6612409904223379905L;

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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectAffiliation() {
        return projectAffiliation;
    }

    public void setProjectAffiliation(String projectAffiliation) {
        this.projectAffiliation = projectAffiliation;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
