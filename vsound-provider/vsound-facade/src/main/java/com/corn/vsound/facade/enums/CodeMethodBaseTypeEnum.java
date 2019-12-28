package com.corn.vsound.facade.enums;

/**
 * @author yyc
 * @apiNote 源码方法基础类型枚举
 * @createTime 2019/12/28
 */
public enum CodeMethodBaseTypeEnum  {

    ABSTRACT("ABSTRACT","抽象方法"),
    STATIC("STATIC","静态方法");

    private final String code;

    private final String msg;

    CodeMethodBaseTypeEnum(String code, String msg) {
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
