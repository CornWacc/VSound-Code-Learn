package com.corn.vsound.facade.code.order;

import com.corn.boot.base.pojobase.BaseOrder;

public class CodeDetailQueryOrder extends BaseOrder {
    private static final long serialVersionUID = 6585657227681476991L;

    private String codeId;

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }
}
