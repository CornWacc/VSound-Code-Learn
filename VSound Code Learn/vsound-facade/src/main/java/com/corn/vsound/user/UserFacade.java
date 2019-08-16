package com.corn.vsound.user;

import com.corn.vsound.user.create.UserCreateOrder;
import com.corn.vsound.user.create.UserCreateResult;
import com.corn.vsound.user.login.UserLoginOrder;
import com.corn.vsound.user.login.UserLoginResult;

/**
 * @author yyc
 * @apiNote 用户业务外部接口
 * */
public interface UserFacade{

    /**
     * 用户登录
     * */
    UserLoginResult userLogin(UserLoginOrder order);

    /**
     * 用户创建
     * */
    UserCreateResult userCreate(UserCreateOrder order);
}
