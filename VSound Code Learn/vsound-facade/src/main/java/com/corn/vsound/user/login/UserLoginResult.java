package com.corn.vsound.user.login;

import com.corn.boot.base.BaseRes;
import com.corn.vsound.user.info.UserInfo;


/**
 * @author yyc
 * @apiNote 用户登录返回参数
 * */
public class UserLoginResult extends BaseRes {
    private static final long serialVersionUID = 2415531166109650909L;


    /**
     * 用户基础资料
     * */
    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
