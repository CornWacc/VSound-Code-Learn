package com.corn.vsound.facade.code.order;

import com.corn.boot.base.pojobase.BaseOrder;


/**
 * @author yyc
 * @apiNote 源码列表查询入参
 * */
public class CodeMethodListQueryOrder extends BaseOrder {
    private static final long serialVersionUID = 177840151745773559L;

    /**
     * 源码id
     * */
    private String codeId;

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }
}
