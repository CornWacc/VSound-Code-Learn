package com.corn.vsound.facade.project.info;

import com.corn.boot.base.pojobase.Base;
import com.corn.vsound.facade.enums.UsePositionEnum;

/**
 * @author yyc
 */
public class ProjectInfo extends Base {

    private static final long serialVersionUID = -6612409904223379905L;

    private String projectName;

    private String projectId;

    private String projectType;

    private UsePositionEnum usePosition;

    private String usePositionCN;

    private String remark;

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

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public UsePositionEnum getUsePosition() {
        return usePosition;
    }

    public void setUsePosition(UsePositionEnum usePosition) {
        this.usePosition = usePosition;
    }

    public String getUsePositionCN() {
        return usePositionCN;
    }

    public void setUsePositionCN(String usePositionCN) {
        this.usePositionCN = usePositionCN;
    }
}
