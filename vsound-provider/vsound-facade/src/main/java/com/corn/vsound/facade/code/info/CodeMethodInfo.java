package com.corn.vsound.facade.code.info;

import com.corn.boot.base.pojobase.Base;

public class CodeMethodInfo extends Base {
    private static final long serialVersionUID = 6567091441455143861L;

    private String methodId;

    private String methodName;

    private String methodUsage;

    private String methodNotice;

    private String methodOrder;

    private String methodResult;

    private String isAbstract;

    private String methodCommonUse;

    private String fromCodeId;

    public String getMethodId() {
        return methodId;
    }

    public void setMethodId(String methodId) {
        this.methodId = methodId;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodUsage() {
        return methodUsage;
    }

    public void setMethodUsage(String methodUsage) {
        this.methodUsage = methodUsage;
    }

    public String getMethodNotice() {
        return methodNotice;
    }

    public void setMethodNotice(String methodNotice) {
        this.methodNotice = methodNotice;
    }

    public String getMethodOrder() {
        return methodOrder;
    }

    public void setMethodOrder(String methodOrder) {
        this.methodOrder = methodOrder;
    }

    public String getMethodResult() {
        return methodResult;
    }

    public void setMethodResult(String methodResult) {
        this.methodResult = methodResult;
    }

    public String getIsAbstract() {
        return isAbstract;
    }

    public void setIsAbstract(String isAbstract) {
        this.isAbstract = isAbstract;
    }

    public String getMethodCommonUse() {
        return methodCommonUse;
    }

    public void setMethodCommonUse(String methodCommonUse) {
        this.methodCommonUse = methodCommonUse;
    }

    public String getFromCodeId() {
        return fromCodeId;
    }

    public void setFromCodeId(String fromCodeId) {
        this.fromCodeId = fromCodeId;
    }
}
