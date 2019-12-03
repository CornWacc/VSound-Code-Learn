package com.corn.vsound.web.project.ao;

public class ProjectCUDAO {

    private String cudType;

    private String projectId;

    private String projectName;

    private String projectAffiliation;

    private String projectType;

    private String usePosition;

    private String remark;

//    private String createUserId;
//
//    private String createUserName;


    public String getCudType() {
        return cudType;
    }

    public void setCudType(String cudType) {
        this.cudType = cudType;
    }

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
}
