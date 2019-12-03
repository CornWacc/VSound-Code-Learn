package com.corn.vsound.web.user;


import com.corn.boot.base.JsonResult;
import com.corn.boot.util.AppUtils;
import com.corn.vsound.integration.user.UserFacadeClient;
import com.corn.vsound.web.account.AccountCache;
import com.corn.vsound.web.user.ao.UserLoginAO;
import com.corn.vworld.facade.enums.LoginOSEnums;
import com.corn.vworld.facade.user.login.UserLoginOrder;
import com.corn.vworld.facade.user.login.UserLoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFacadeClient userFacadeClient;

    @Autowired
    private AccountCache accountCache;

    @PostMapping("/userLogin")
    public JsonResult userLogin(@RequestBody @Valid UserLoginAO userLoginAo){

        UserLoginOrder order = new UserLoginOrder();
        order.setUserAccount(userLoginAo.getUserAccount());
        order.setUserPassword(userLoginAo.getUserPassword());
        order.setSerialNo(AppUtils.appCode(""));
        order.setLoginOS(userLoginAo.getLoginOS());

        UserLoginResult result = userFacadeClient.userLogin(order);

        //设置用户本地缓存
        if(result.isSuccess()){
            accountCache.setUserCache(result);
        }
        return new JsonResult(result);
    }
}
