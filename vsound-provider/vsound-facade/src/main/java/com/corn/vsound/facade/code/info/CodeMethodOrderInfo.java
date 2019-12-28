package com.corn.vsound.facade.code.info;

import com.corn.boot.base.pojobase.Base;

/**
 * @author yyc
 * @apiNote 方法入参实体
 * @createTime 2019/12/28
 */
public class CodeMethodOrderInfo extends Base {

    private static final long serialVersionUID = 6618376117264416851L;

    /**
     * 方法入参id
     * */
    private String codeMethodOrderId;

    /**
     * 方法入参名称
     * */
    private String codeMethodOrderName;

    /**
     * 方法入参源类型
     * */
    private String codeMethodOrderClassType;

    /**
     * 方法入参类型
     * */
    private String codeMethodOrderType;

    /**
     * 所属方法id
     * */
    private String codeMethodId;

    public String getCodeMethodOrderId() {
        return codeMethodOrderId;
    }

    public void setCodeMethodOrderId(String codeMethodOrderId) {
        this.codeMethodOrderId = codeMethodOrderId;
    }

    public String getCodeMethodOrderName() {
        return codeMethodOrderName;
    }

    public void setCodeMethodOrderName(String codeMethodOrderName) {
        this.codeMethodOrderName = codeMethodOrderName;
    }

    public String getCodeMethodOrderClassType() {
        return codeMethodOrderClassType;
    }

    public void setCodeMethodOrderClassType(String codeMethodOrderClassType) {
        this.codeMethodOrderClassType = codeMethodOrderClassType;
    }

    public String getCodeMethodOrderType() {
        return codeMethodOrderType;
    }

    public void setCodeMethodOrderType(String codeMethodOrderType) {
        this.codeMethodOrderType = codeMethodOrderType;
    }

    public String getCodeMethodId() {
        return codeMethodId;
    }

    public void setCodeMethodId(String codeMethodId) {
        this.codeMethodId = codeMethodId;
    }
}
