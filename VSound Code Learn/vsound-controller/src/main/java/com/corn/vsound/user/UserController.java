package com.corn.vsound.user;

import com.corn.boot.base.BaseController;
import com.corn.boot.base.JsonResult;
import com.corn.boot.util.AppUtils;
import com.corn.vsound.user.list.UserListQueryOrder;
import com.corn.vsound.user.list.UserListQueryResult;
import com.corn.vsound.user.login.UserLoginOrder;
import com.corn.vsound.user.login.UserLoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @author yyc
 * @apiNote 用户基础接口
 * */
@RestController
@RequestMapping("/base/user/")
public class UserController extends BaseController {

    @Autowired
    private UserFacade userFacade;

    @PostMapping("userLogin")
    public JsonResult userLogin(@RequestBody UserLoginOrder order){
        order.setSerialNo(AppUtils.appCode("userLogin"));
        UserLoginResult userLoginResult = userFacade.userLogin(order);
        return new JsonResult(userLoginResult);
    }

    @GetMapping("userListQuery")
    public JsonResult userListQuery(){
        UserListQueryOrder order = new UserListQueryOrder();
        order.setSerialNo(AppUtils.appCode("userListQuery"));
        UserListQueryResult result = userFacade.userListQuery(order);
        return new JsonResult(result);
    }
}
