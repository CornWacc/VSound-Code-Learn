package com.corn.vsound.facade.code.info;

import com.corn.boot.base.pojobase.Base;

public class CodeInfo extends Base {

    private String codeId;

    private String codeName;

    private String codeType;

    private String fromProjectId;

    private Integer methodCount;

    private Integer parameterCount;

    private Integer outSideUrlCount;

    private String codeRemark;

    public String getCodeRemark() {
        return codeRemark;
    }

    public void setCodeRemark(String codeRemark) {
        this.codeRemark = codeRemark;
    }

    public Integer getMethodCount() {
        return methodCount;
    }

    public void setMethodCount(Integer methodCount) {
        this.methodCount = methodCount;
    }

    public Integer getParameterCount() {
        return parameterCount;
    }

    public void setParameterCount(Integer parameterCount) {
        this.parameterCount = parameterCount;
    }

    public Integer getOutSideUrlCount() {
        return outSideUrlCount;
    }

    public void setOutSideUrlCount(Integer outSideUrlCount) {
        this.outSideUrlCount = outSideUrlCount;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getFromProjectId() {
        return fromProjectId;
    }

    public void setFromProjectId(String fromProjectId) {
        this.fromProjectId = fromProjectId;
    }
}
