package com.corn.vsound.user.info;

import com.corn.boot.base.Base;

/**
 * @author yyc
 * @apiNote 用户基础信息
 * */
public class UserInfo extends Base {
    private static final long serialVersionUID = 3059581382203975388L;

    /**
     * 用户id
     * */
    private String userId;

    /**
     * 用户名称
     * */
    private String userName;

    /**
     * 用户登录账号
     * */
    private String userAccount;

    private String token;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
