package com.corn.vsound.web.code;

import com.corn.boot.annotations.RequestLog;
import com.corn.boot.base.JsonResult;
import com.corn.boot.util.AppUtils;
import com.corn.vsound.facade.code.order.CodeCUDOrder;
import com.corn.vsound.facade.code.order.CodeDetailQueryOrder;
import com.corn.vsound.facade.code.result.CodeCUDResult;
import com.corn.vsound.facade.code.result.CodeDetailQueryResult;
import com.corn.vsound.integration.code.CodeFacadeClient;
import com.corn.vsound.web.code.ao.CodeCUDAO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

@RequestMapping("/code")
@RestController
public class CodeController {

    @Autowired
    private CodeFacadeClient codeFacadeClient;

    @PostMapping("/codeCUD")
    @RequestLog("源码CUD请求")
    public JsonResult codeCUD(@RequestBody CodeCUDAO ao){
        CodeCUDOrder order = new CodeCUDOrder();
        BeanCopier.create(CodeCUDAO.class,CodeCUDOrder.class,false).copy(ao,order,null);
        order.setSerialNo(AppUtils.appCode(""));
        CodeCUDResult result = codeFacadeClient.codeCUD(order);
        return new JsonResult(result);
    }

    @GetMapping("/codeDetailQuery")
    @RequestLog("源码详情查看请求")
    public JsonResult codeDetailQuery(String codeId){
        CodeDetailQueryOrder order = new CodeDetailQueryOrder();
        order.setCodeId(codeId);
        order.setSerialNo(AppUtils.appCode(""));

        CodeDetailQueryResult result = codeFacadeClient.codeDetailQuery(order);
        return new JsonResult(result);
    }

}
