package com.corn.vsound.facade.project.order;

import com.corn.boot.annotations.CudParamsCheck;
import com.corn.boot.base.pojobase.BaseOrder;
import com.corn.boot.base.strategy.CUDOrder;
import com.corn.boot.enums.CudTypeEnum;
import com.corn.vsound.facade.enums.UsePositionEnum;

/**
 * @author yyc
 */
public class ProjectCUDOrder extends CUDOrder {

    @CudParamsCheck(cudTypes = {CudTypeEnum.DELETE,CudTypeEnum.UPDATE},errorMsg = "项目Id不能为空")
    private String projectId;

    private String projectName;

    private String projectAffiliation;

    private String projectType;

    private UsePositionEnum usePosition;

    private String remark;

    private Integer gatherClassCount;

    private Integer gatherInterfaceCount;

    private String createUserId;

    private String createUserName;

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

    public String getRemark() {
        return remark;
    }

    public UsePositionEnum getUsePosition() {
        return usePosition;
    }

    public void setUsePosition(UsePositionEnum usePosition) {
        this.usePosition = usePosition;
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
