package com.corn.vsound.web.project.ao;

import com.corn.boot.enums.CudTypeEnum;
import com.corn.vsound.facade.enums.UsePositionEnum;

public class ProjectCUDAO {

    private CudTypeEnum cudType;

    private String projectId;

    private String projectName;

    private String projectType;

    private UsePositionEnum usePosition;

    private String remark;

//    private String createUserId;
//
//    private String createUserName;


    public CudTypeEnum getCudType() {
        return cudType;
    }

    public void setCudType(CudTypeEnum cudType) {
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

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public UsePositionEnum getUsePosition() {
        return usePosition;
    }

    public void setUsePosition(UsePositionEnum usePosition) {
        this.usePosition = usePosition;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
