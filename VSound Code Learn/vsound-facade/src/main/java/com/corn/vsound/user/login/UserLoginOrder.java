package com.corn.vsound.user.login;

import com.corn.boot.base.BaseOrder;



/**
 * @author yy
 * @apiNote 用户登录入参
 * */
public class UserLoginOrder extends BaseOrder {
    private static final long serialVersionUID = -6758985393770409322L;

    /**
     * 登录账号
     * */
    private String userAccount;

    /**
     * 登录密码
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

