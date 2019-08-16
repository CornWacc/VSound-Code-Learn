package com.corn.vsound.user;

import com.corn.vsound.base.BaseFacade;
import com.corn.vsound.user.create.UserCreateOrder;
import com.corn.vsound.user.create.UserCreateResult;
import com.corn.vsound.user.delegate.UserLoginDelegate;
import com.corn.vsound.user.login.UserLoginOrder;
import com.corn.vsound.user.login.UserLoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author yyc
 * @apiNote 用户业务实现类
 * */
@Service
public class UserFacadeImpl extends BaseFacade implements UserFacade {

    @Autowired
    private UserLoginDelegate userLoginDelegate;

    @Override
    public UserLoginResult userLogin(UserLoginOrder order) {
        return userLoginDelegate.execute("用户登录业务",order);
    }

    @Override
    public UserCreateResult userCreate(UserCreateOrder order) {
        return null;
    }
}
