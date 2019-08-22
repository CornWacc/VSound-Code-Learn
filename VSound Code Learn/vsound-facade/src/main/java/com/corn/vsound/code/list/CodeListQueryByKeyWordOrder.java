package com.corn.vsound.code.list;

import com.corn.boot.base.BaseOrder;


/**
 * @author yyc
 * @apiNote 源码列表查询入参
 * */
public class CodeListQueryByKeyWordOrder extends BaseOrder {
    private static final long serialVersionUID = 6789853738816619820L;

    private String programId;

    private String codeName;

    private Integer codeLevel;

    private String codeType;

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public Integer getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(Integer codeLevel) {
        this.codeLevel = codeLevel;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

}
