package com.corn.vsound.web.code;

import com.corn.boot.annotations.RequestLog;
import com.corn.boot.base.JsonResult;
import com.corn.boot.util.AppUtils;
import com.corn.vsound.facade.code.order.CodeCUDOrder;
import com.corn.vsound.facade.code.order.CodeDetailQueryOrder;
import com.corn.vsound.facade.code.order.CodeMethodCUDOrder;
import com.corn.vsound.facade.code.order.CodeMethodListQueryOrder;
import com.corn.vsound.facade.code.result.CodeCUDResult;
import com.corn.vsound.facade.code.result.CodeDetailQueryResult;
import com.corn.vsound.facade.code.result.CodeMethodCUDResult;
import com.corn.vsound.facade.code.result.CodeMethodListQueryResult;
import com.corn.vsound.integration.code.CodeFacadeClient;
import com.corn.vsound.web.code.ao.CodeCUDAO;
import com.corn.vsound.web.code.ao.CodeMethodAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/codeMethodCUD")
    @RequestLog("源码方法CUD操作")
    public JsonResult codeMethodCUD(@RequestBody CodeMethodAO ao) throws InterruptedException {
        CodeMethodCUDOrder order = new CodeMethodCUDOrder();
        BeanCopier.create(CodeMethodAO.class,CodeMethodCUDOrder.class,false).copy(ao,order,null);
        order.setSerialNo(AppUtils.appCode(""));
        CodeMethodCUDResult result = codeFacadeClient.codeMethodCUD(order);
        return new JsonResult(result);
    }

    @GetMapping("/codeMethodListQuery")
    @RequestLog("源码方法列表查询")
    public JsonResult codeMethodListQuery(String codeId){
        CodeMethodListQueryOrder order = new CodeMethodListQueryOrder();
        order.setCodeId(codeId);
        order.setSerialNo(AppUtils.appCode(""));

        CodeMethodListQueryResult result = codeFacadeClient.codeMethodListQuery(order);
        return new JsonResult(result);
    }



}
