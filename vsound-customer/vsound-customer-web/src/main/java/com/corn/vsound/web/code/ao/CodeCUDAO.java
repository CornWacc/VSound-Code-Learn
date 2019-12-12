package com.corn.vsound.web.code.ao;

import com.corn.boot.enums.CudTypeEnum;

public class CodeCUDAO {

    private CudTypeEnum cudType;

    private String codeName;

    private String codeType;

    private Integer codeLevel;

    private String codeProgram;

    private String codeId;

    private String codeRemark;

    private String usePosition;

    public String getCodeRemark() {
        return codeRemark;
    }

    public void setCodeRemark(String codeRemark) {
        this.codeRemark = codeRemark;
    }

    public String getUsePosition() {
        return usePosition;
    }

    public void setUsePosition(String usePosition) {
        this.usePosition = usePosition;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public CudTypeEnum getCudType() {
        return cudType;
    }

    public void setCudType(CudTypeEnum cudType) {
        this.cudType = cudType;
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

    public Integer getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(Integer codeLevel) {
        this.codeLevel = codeLevel;
    }

    public String getCodeProgram() {
        return codeProgram;
    }

    public void setCodeProgram(String codeProgram) {
        this.codeProgram = codeProgram;
    }
}
