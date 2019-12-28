package com.corn.vsound.facade.enums;

/**
 * @author yyc
 * @apiNote
 * @createTime 2019/12/28
 */
public enum ActionScopeEnum {

    PUBLIC("PUBLIC","公共"),
    PRIVATE("PRIVATE","私有"),
    PROTECTED("PROTECTED","子类可用");

    private final String code;

    private final String msg;

    ActionScopeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
