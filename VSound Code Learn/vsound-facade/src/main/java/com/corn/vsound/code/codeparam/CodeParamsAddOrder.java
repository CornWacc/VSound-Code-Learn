package com.corn.vsound.code.codeparam;

import com.corn.boot.base.BaseOrder;



/**
 * @author yyc
 * @apiNote 源码内容新增入参 方法/参数/链接
 * */
public class CodeParamsAddOrder extends BaseOrder {
    private static final long serialVersionUID = -3937042738643538887L;

    private String type;

    private Object info;

    private String codeId;

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }
}
