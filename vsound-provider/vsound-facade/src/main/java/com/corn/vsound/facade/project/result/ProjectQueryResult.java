package com.corn.vsound.facade.project.result;

import com.corn.boot.base.pojobase.BaseRes;
import com.corn.vsound.facade.code.info.CodeInfo;

import java.util.List;


/**
 * @author yyc
 * @apiNote 项目单查询出参
 * */
public class ProjectQueryResult extends BaseRes {

    private String projectName;

    private String projectId;

    private String projectAffiliation;

    private String projectType;

    private String usePosition;

    private String remark;

    private Integer gatherClassCount;

    private Integer gatherInterfaceCount;

    private String createUserId;

    private String createUserName;

    private List<CodeInfo> codeInfoList;

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

    public List<CodeInfo> getCodeInfoList() {
        return codeInfoList;
    }

    public void setCodeInfoList(List<CodeInfo> codeInfoList) {
        this.codeInfoList = codeInfoList;
    }
}
