package com.corn.vsound.code.list;

import com.corn.boot.base.BaseOrder;


/**
 * @author yyc
 * @apiNote 源码列表查询入参
 * */
public class CodeListQueryByKeyWordOrder extends BaseOrder {
    private static final long serialVersionUID = 6789853738816619820L;

    private String programId;

    private String keyWord;

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
