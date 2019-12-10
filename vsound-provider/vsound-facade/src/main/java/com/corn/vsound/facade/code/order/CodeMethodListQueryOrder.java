package com.corn.vsound.facade.code.order;

import com.corn.boot.base.pojobase.BaseOrder;

public class CodeMethodListQueryOrder extends BaseOrder {
    private static final long serialVersionUID = 177840151745773559L;

    private String codeId;

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }
}
