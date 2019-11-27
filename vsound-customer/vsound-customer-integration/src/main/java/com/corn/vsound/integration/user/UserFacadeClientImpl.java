package com.corn.vsound.integration.user;


import com.corn.boot.annotations.Log;
import com.corn.vworld.facade.user.UserFacade;
import com.corn.vworld.facade.user.infoquery.UserInfoQueryOrder;
import com.corn.vworld.facade.user.infoquery.UserInfoQueryResult;
import com.corn.vworld.facade.user.login.UserLoginOrder;
import com.corn.vworld.facade.user.login.UserLoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yyc
 * @apiNote 用户远程调用服务客户端
 * */
@Service
public class UserFacadeClientImpl implements UserFacadeClient {

    @Autowired
    private UserFacade userFacade;

    @Log(name = "用户服务",des = "用户登录")
    public UserLoginResult userLogin(UserLoginOrder order) {
        UserLoginResult userLoginResult = userFacade.userLogin(order);
        return userLoginResult;
    }

    @Log(name = "用户服务",des = "用户基础信息查询")
    public UserInfoQueryResult userInfoQuery(UserInfoQueryOrder order) {
        return null;
    }
}
