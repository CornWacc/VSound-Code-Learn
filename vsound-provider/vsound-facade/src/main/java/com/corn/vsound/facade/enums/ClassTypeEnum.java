package com.corn.vsound.facade.enums;

/**
 * @author yyc
 * @apiNote
 * @createTime 2020/1/15
 */
public enum ClassTypeEnum {

    CLASS("CLASS","类"),
    ENUM("ENUM","枚举"),
    INTERFACE("INTERFACE","接口"),
    ANNOTATION("ANNOTATION","注解");

    private final String code;

    private final String msg;

    ClassTypeEnum(String code, String msg) {
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
