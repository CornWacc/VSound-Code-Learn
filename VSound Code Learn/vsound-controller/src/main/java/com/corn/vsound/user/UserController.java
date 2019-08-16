package com.corn.vsound.user;

import com.corn.boot.base.BaseController;
import com.corn.boot.base.JsonResult;
import com.corn.boot.util.AppUtils;
import com.corn.vsound.user.login.UserLoginOrder;
import com.corn.vsound.user.login.UserLoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author yyc
 * @apiNote 用户基础接口
 * */
@RestController
@RequestMapping("/base/user/")
public class UserController extends BaseController {

    @Autowired
    private UserFacade userFacade;

    @GetMapping("userLogin")
    public JsonResult userLogin(UserLoginOrder order){
        order.setSerialNo(AppUtils.appCode("userLogin"));
        UserLoginResult userLoginResult = userFacade.userLogin(order);
        return new JsonResult(userLoginResult);
    }
}
