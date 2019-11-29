package com.corn.vsound.dao.entity;

public class CodeMethod {
    private Integer id;

    private String methodId;

    private String methodName;

    private String methodUsage;

    private String methodNotice;

    private String methodOrder;

    private String methodResult;

    private String isAbstract;

    private String methodCommonUse;

    private String fromCodeId;

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

    public String getMethodNotice() {
        return methodNotice;
    }

    public void setMethodNotice(String methodNotice) {
        this.methodNotice = methodNotice == null ? null : methodNotice.trim();
    }

    public String getMethodOrder() {
        return methodOrder;
    }

    public void setMethodOrder(String methodOrder) {
        this.methodOrder = methodOrder == null ? null : methodOrder.trim();
    }

    public String getMethodResult() {
        return methodResult;
    }

    public void setMethodResult(String methodResult) {
        this.methodResult = methodResult == null ? null : methodResult.trim();
    }

    public String getIsAbstract() {
        return isAbstract;
    }

    public void setIsAbstract(String isAbstract) {
        this.isAbstract = isAbstract == null ? null : isAbstract.trim();
    }

    public String getMethodCommonUse() {
        return methodCommonUse;
    }

    public void setMethodCommonUse(String methodCommonUse) {
        this.methodCommonUse = methodCommonUse == null ? null : methodCommonUse.trim();
    }

    public String getFromCodeId() {
        return fromCodeId;
    }

    public void setFromCodeId(String fromCodeId) {
        this.fromCodeId = fromCodeId == null ? null : fromCodeId.trim();
    }
}