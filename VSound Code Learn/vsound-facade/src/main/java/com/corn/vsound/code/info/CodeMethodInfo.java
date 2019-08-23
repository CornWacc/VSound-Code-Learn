package com.corn.vsound.code.info;

import com.corn.boot.base.BaseOrder;

public class CodeMethodInfo extends BaseOrder {
    private static final long serialVersionUID = -5542726072191263929L;

    private String methodName;

    private String methodsUsage;

    private String methodOrder;

    private String isCommonUse;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodsUsage() {
        return methodsUsage;
    }

    public void setMethodsUsage(String methodsUsage) {
        this.methodsUsage = methodsUsage;
    }

    public String getMethodOrder() {
        return methodOrder;
    }

    public void setMethodOrder(String methodOrder) {
        this.methodOrder = methodOrder;
    }

    public String getIsCommonUse() {
        return isCommonUse;
    }

    public void setIsCommonUse(String isCommonUse) {
        this.isCommonUse = isCommonUse;
    }
}
