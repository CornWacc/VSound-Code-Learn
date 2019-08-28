package com.corn.vsound.code.info;

import com.corn.boot.base.Base;

public class CodeParameterInfo extends Base {
    private static final long serialVersionUID = 554420729874392446L;

    private String parameterId;

    private String parameterName;

    private String parameterType;

    private String parameterRemark;

    private String isFinal;

    private String isAutowire;

    private String isInterface;

    private String fromCodeId;

    public String getParameterId() {
        return parameterId;
    }

    public void setParameterId(String parameterId) {
        this.parameterId = parameterId;
    }

    public String getIsFinal() {
        return isFinal;
    }

    public void setIsFinal(String isFinal) {
        this.isFinal = isFinal;
    }

    public String getIsAutowire() {
        return isAutowire;
    }

    public void setIsAutowire(String isAutowire) {
        this.isAutowire = isAutowire;
    }

    public String getIsInterface() {
        return isInterface;
    }

    public void setIsInterface(String isInterface) {
        this.isInterface = isInterface;
    }

    public String getFromCodeId() {
        return fromCodeId;
    }

    public void setFromCodeId(String fromCodeId) {
        this.fromCodeId = fromCodeId;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getParameterRemark() {
        return parameterRemark;
    }

    public void setParameterRemark(String parameterRemark) {
        this.parameterRemark = parameterRemark;
    }
}
