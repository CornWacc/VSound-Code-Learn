package com.corn.vsound.user.delegate;

import com.corn.boot.base.AbstractBizService;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.entity.UserBase;
import com.corn.vsound.dao.mapper.UserBaseMapper;
import com.corn.vsound.user.info.UserInfo;
import com.corn.vsound.user.login.UserLoginOrder;
import com.corn.vsound.user.login.UserLoginResult;
import com.google.gson.Gson;
import io.netty.util.internal.ObjectUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


/**
 * @author yyc
 * @apiNote 用户登录实现
 * */
@Service
public class UserLoginDelegate extends AbstractBizService<UserLoginOrder, UserLoginResult> {

    @Autowired
    private UserBaseMapper userBaseMapper;

    @Override
    protected UserLoginResult initResult() {
        return new UserLoginResult();
    }

    @Override
    protected void orderCheck(UserLoginOrder order) {
        order.orderCheck();
    }

    @Override
    protected void appBiz(UserLoginOrder order, UserLoginResult result) {

        UserBase userBase = userBaseMapper.findUserByUserAccountAndUserPassword(order.getUserAccount(),order.getUserPassword());
        if(!ObjectUtils.isEmpty(userBase)){

            UserInfo userInfo = new UserInfo();
            BeanUtils.copyProperties(userBase,userInfo);
            result.setUserInfo(userInfo);
        }else{
            throw new BizError("用户登录失败!");
        }

    }
}
