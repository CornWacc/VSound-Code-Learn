package com.corn.vsound.dao.entity;

import java.util.Date;

public class CodeParameter {
    private Integer id;

    private String parameterId;

    private String parameterName;

    private String parameterRemark;

    private String parameterType;

    private String isFinal;

    private String isAutowire;

    private String isInterface;

    private String fromCodeId;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParameterId() {
        return parameterId;
    }

    public void setParameterId(String parameterId) {
        this.parameterId = parameterId == null ? null : parameterId.trim();
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName == null ? null : parameterName.trim();
    }

    public String getParameterRemark() {
        return parameterRemark;
    }

    public void setParameterRemark(String parameterRemark) {
        this.parameterRemark = parameterRemark == null ? null : parameterRemark.trim();
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType == null ? null : parameterType.trim();
    }

    public String getIsFinal() {
        return isFinal;
    }

    public void setIsFinal(String isFinal) {
        this.isFinal = isFinal == null ? null : isFinal.trim();
    }

    public String getIsAutowire() {
        return isAutowire;
    }

    public void setIsAutowire(String isAutowire) {
        this.isAutowire = isAutowire == null ? null : isAutowire.trim();
    }

    public String getIsInterface() {
        return isInterface;
    }

    public void setIsInterface(String isInterface) {
        this.isInterface = isInterface == null ? null : isInterface.trim();
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