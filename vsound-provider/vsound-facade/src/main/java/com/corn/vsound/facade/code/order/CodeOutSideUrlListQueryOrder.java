package com.corn.vsound.facade.code.order;

import com.corn.boot.base.pojobase.BaseOrder;

/**
 * @author yyc
 * @apiNote
 * @createTime 2019/12/12
 */
public class CodeOutSideUrlListQueryOrder extends BaseOrder {

    private String codeId;

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }
}
