package com.corn.vsound.web.code.ao;

import com.corn.boot.enums.CudTypeEnum;

/**
 * @author yyc
 * @apiNote
 * @createTime 2019/12/11
 */
public class CodeParameterAO {

    private String parameterId;

    private String parameterName;

    private String parameterRemark;

    private String parameterType;

    private String isFinal;

    private String isAutowire;

    private String isInterface;

    private String fromCodeId;

    private CudTypeEnum cudType;

    public CudTypeEnum getCudType() {
        return cudType;
    }

    public void setCudType(CudTypeEnum cudType) {
        this.cudType = cudType;
    }

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
