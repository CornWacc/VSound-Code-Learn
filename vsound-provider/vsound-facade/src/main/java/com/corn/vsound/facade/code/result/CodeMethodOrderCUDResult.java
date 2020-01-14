package com.corn.vsound.facade.code.result;

import com.corn.boot.base.pojobase.BaseRes;

/**
 * @author yyc
 * @apiNote 源码方法入参CUD出参
 * @createTime 2020/1/9
 */
public class CodeMethodOrderCUDResult extends BaseRes {

    private static final long serialVersionUID = -6289878846667516787L;

    /**
     * 源码方法入参id
     * */
    private String codeMethodOrderId;

    public String getCodeMethodOrderId() {
        return codeMethodOrderId;
    }

    public void setCodeMethodOrderId(String codeMethodOrderId) {
        this.codeMethodOrderId = codeMethodOrderId;
    }
}
