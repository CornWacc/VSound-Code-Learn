package com.corn.vsound.web.code;

import com.corn.boot.annotations.RequestLog;
import com.corn.boot.base.JsonResult;
import com.corn.boot.util.AppUtils;
import com.corn.vsound.facade.code.order.CodeCUDOrder;
import com.corn.vsound.facade.code.result.CodeCUDResult;
import com.corn.vsound.integration.code.CodeFacadeClient;
import com.corn.vsound.web.code.ao.CodeCUDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/code")
@RestController
public class CodeController {

    @Autowired
    private CodeFacadeClient codeFacadeClient;

    @PostMapping("/codeCUD")
//    @RequestLog("源码CUD请求")
    public JsonResult codeCUD(@RequestBody CodeCUDAO ao){
        CodeCUDOrder order = new CodeCUDOrder();
        BeanCopier.create(CodeCUDAO.class,CodeCUDOrder.class,false).copy(ao,order,null);
        order.setSerialNo(AppUtils.appCode(""));
        CodeCUDResult result = codeFacadeClient.codeCUD(order);
        return new JsonResult(result);
    }



}
