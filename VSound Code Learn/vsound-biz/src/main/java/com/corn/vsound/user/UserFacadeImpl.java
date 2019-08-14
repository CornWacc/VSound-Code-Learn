package com.corn.vsound.user;

import com.corn.vsound.base.BaseFacade;
import com.corn.vsound.user.create.UserCreateOrder;
import com.corn.vsound.user.create.UserCreateResult;
import com.corn.vsound.user.login.UserLoginOrder;
import com.corn.vsound.user.login.UserLoginResult;
import org.springframework.stereotype.Service;


/**
 * @author yyc
 * @apiNote 用户业务实现类
 * */
@Service
public class UserFacadeImpl extends BaseFacade implements UserFacade {
    @Override
    public UserLoginResult userLogin(UserLoginOrder order) {
        return null;
    }

    @Override
    public UserCreateResult userCreate(UserCreateOrder order) {
        return null;
    }
}
