package com.corn.vsound.facade.enums;

/**
 * @author yyc
 * @apiNote
 * @createTime 2020/1/16
 */
public enum UsePositionEnum {

    ALL("ALL","全局"),
    RPC("RPC","远程调用"),
    WEB("WEB","网络"),
    DAO("DAO","持久层"),
    SERIALIZE("SERIALIZE","序列化"),
    UTIL("UTIL","工具");

    UsePositionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private final String code;

    private final String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
