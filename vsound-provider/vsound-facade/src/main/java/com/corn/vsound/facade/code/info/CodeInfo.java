package com.corn.vsound.facade.code.info;

import com.corn.boot.base.pojobase.Base;

public class CodeInfo extends Base {

    private String codeId;

    private String codeName;

    private String codeType;

    private Integer codeLevel;

    private String codeProgram;

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
