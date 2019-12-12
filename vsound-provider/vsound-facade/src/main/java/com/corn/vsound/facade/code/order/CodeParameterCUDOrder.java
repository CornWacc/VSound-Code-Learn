package com.corn.vsound.facade.code.order;

import com.corn.boot.base.strategy.CUDOrder;

/**
 * @author yyc
 * */
public class CodeParameterCUDOrder extends CUDOrder {

    private static final long serialVersionUID = 8639613728066965281L;

    private String parameterId;

    private String parameterName;

    private String parameterRemark;

    private String parameterType;

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

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterRemark() {
        return parameterRemark;
    }

    public void setParameterRemark(String parameterRemark) {
        this.parameterRemark = parameterRemark;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
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
}
