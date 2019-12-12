package com.corn.vsound.facade.code.order;

import com.corn.boot.base.pojobase.BaseOrder;

/**
 * @author yyc
 * @apiNote
 * @createTime 2019/12/11
 */
public class CodeParameterListQueryOrder extends BaseOrder {
    private static final long serialVersionUID = 8729928988429262188L;

    private String codeId;

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }
}
