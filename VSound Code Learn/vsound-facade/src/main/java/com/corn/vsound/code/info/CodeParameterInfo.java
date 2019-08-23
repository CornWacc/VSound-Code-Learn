package com.corn.vsound.code.info;

import com.corn.boot.base.Base;

public class CodeParameterInfo extends Base {
    private static final long serialVersionUID = 554420729874392446L;

    private String parameterName;

    private String parameterType;

    private String parameterRemark;

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
