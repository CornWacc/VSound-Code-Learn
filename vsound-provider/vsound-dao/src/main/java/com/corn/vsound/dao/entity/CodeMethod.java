package com.corn.vsound.dao.entity;

import com.corn.vsound.facade.enums.ActionScopeEnum;
import com.corn.vsound.facade.enums.CodeMethodBaseTypeEnum;
import com.corn.vsound.facade.enums.YNEnum;

import java.util.Date;

public class CodeMethod {
    private Integer id;

    private String methodId;

    private String methodName;

    private String methodUsage;

    private String methodResult;

    private CodeMethodBaseTypeEnum methodBaseType;

    private YNEnum methodCommonUse;

    private YNEnum methodIsOverwrite;

    private YNEnum methodIsConstruct;

    private ActionScopeEnum methodActionScope;

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

    public CodeMethodBaseTypeEnum getMethodBaseType() {
        return methodBaseType;
    }

    public void setMethodBaseType(CodeMethodBaseTypeEnum methodBaseType) {
        this.methodBaseType = methodBaseType;
    }

    public YNEnum getMethodCommonUse() {
        return methodCommonUse;
    }

    public void setMethodCommonUse(YNEnum methodCommonUse) {
        this.methodCommonUse = methodCommonUse;
    }

    public YNEnum getMethodIsOverwrite() {
        return methodIsOverwrite;
    }

    public void setMethodIsOverwrite(YNEnum methodIsOverwrite) {
        this.methodIsOverwrite = methodIsOverwrite;
    }

    public YNEnum getMethodIsConstruct() {
        return methodIsConstruct;
    }

    public void setMethodIsConstruct(YNEnum methodIsConstruct) {
        this.methodIsConstruct = methodIsConstruct;
    }

    public ActionScopeEnum getMethodActionScope() {
        return methodActionScope;
    }

    public void setMethodActionScope(ActionScopeEnum methodActionScope) {
        this.methodActionScope = methodActionScope;
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