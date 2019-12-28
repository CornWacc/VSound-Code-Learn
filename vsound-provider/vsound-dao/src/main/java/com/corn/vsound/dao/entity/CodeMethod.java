package com.corn.vsound.dao.entity;

import java.util.Date;

public class CodeMethod {
    private Integer id;

    private String methodId;

    private String methodName;

    private String methodUsage;

    private String methodResult;

    private String methoidBaseType;

    private String methodCommonUse;

    private String methodIsOverwrite;

    private String methodIsConstruct;

    private String methodActionScope;

    private String fromCodeId;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMethodId() {
        return methodId;
    }

    public void setMethodId(String methodId) {
        this.methodId = methodId == null ? null : methodId.trim();
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    public String getMethodUsage() {
        return methodUsage;
    }

    public void setMethodUsage(String methodUsage) {
        this.methodUsage = methodUsage == null ? null : methodUsage.trim();
    }

    public String getMethodResult() {
        return methodResult;
    }

    public void setMethodResult(String methodResult) {
        this.methodResult = methodResult == null ? null : methodResult.trim();
    }

    public String getMethoidBaseType() {
        return methoidBaseType;
    }

    public void setMethoidBaseType(String methoidBaseType) {
        this.methoidBaseType = methoidBaseType == null ? null : methoidBaseType.trim();
    }

    public String getMethodCommonUse() {
        return methodCommonUse;
    }

    public void setMethodCommonUse(String methodCommonUse) {
        this.methodCommonUse = methodCommonUse == null ? null : methodCommonUse.trim();
    }

    public String getMethodIsOverwrite() {
        return methodIsOverwrite;
    }

    public void setMethodIsOverwrite(String methodIsOverwrite) {
        this.methodIsOverwrite = methodIsOverwrite == null ? null : methodIsOverwrite.trim();
    }

    public String getMethodIsConstruct() {
        return methodIsConstruct;
    }

    public void setMethodIsConstruct(String methodIsConstruct) {
        this.methodIsConstruct = methodIsConstruct == null ? null : methodIsConstruct.trim();
    }

    public String getMethodActionScope() {
        return methodActionScope;
    }

    public void setMethodActionScope(String methodActionScope) {
        this.methodActionScope = methodActionScope == null ? null : methodActionScope.trim();
    }

    public String getFromCodeId() {
        return fromCodeId;
    }

    public void setFromCodeId(String fromCodeId) {
        this.fromCodeId = fromCodeId == null ? null : fromCodeId.trim();
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