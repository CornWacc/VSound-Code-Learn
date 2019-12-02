package com.corn.vsound.web.user.ao;

import com.corn.vworld.facade.annotation.EnumConstraintValid;
import com.corn.vworld.facade.enums.LoginOSEnums;

/**
 * @author yyc
 */
public class UserLoginAO {

    private String userAccount;

    private String userPassword;

    @EnumConstraintValid(value = LoginOSEnums.class,message = "登录系统不能为空")
    private String loginOS;

    public String getLoginOS() {
        return loginOS;
    }

    public void setLoginOS(String loginOS) {
        this.loginOS = loginOS;
    }

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
