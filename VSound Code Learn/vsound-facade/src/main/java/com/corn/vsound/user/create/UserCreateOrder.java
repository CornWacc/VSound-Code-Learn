package com.corn.vsound.user.create;

import com.corn.boot.base.BaseOrder;


/**
 * @author yyc
 * @apiNote 用户创建入参
 * */
public class UserCreateOrder extends BaseOrder {

    private static final long serialVersionUID = -1975838834830816606L;

    /**
     * 用户账号
     * */
    private String userAccount;

    /**
     * 用户密码
     * */
    private String userPassword;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
