package com.corn.vsound.code.create;

import com.corn.boot.base.BaseOrder;


public class CodeAddOrder extends BaseOrder {
    private static final long serialVersionUID = 3306504333834703257L;

    private String codeName;

    private String codeType;

    private Integer codeLevel;

    private String codeProgram;

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
