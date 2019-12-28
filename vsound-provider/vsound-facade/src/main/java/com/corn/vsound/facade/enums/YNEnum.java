package com.corn.vsound.facade.enums;

/**
 * @author yyc
 * @apiNote
 * @createTime 2019/12/28
 */
public enum YNEnum {

    Y("Y","是"),
    N("N","否");

    private final String code;

    private final String msg;

    YNEnum(String code, String msg) {
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
