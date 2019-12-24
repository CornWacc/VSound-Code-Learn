package com.corn.vsound.web.code;

import com.corn.boot.annotations.RequestLog;
import com.corn.boot.base.JsonResult;
import com.corn.boot.util.AppUtils;
import com.corn.vsound.facade.code.order.*;
import com.corn.vsound.facade.code.result.*;
import com.corn.vsound.integration.code.CodeFacadeClient;
import com.corn.vsound.web.code.ao.CodeCUDAO;
import com.corn.vsound.web.code.ao.CodeMethodAO;
import com.corn.vsound.web.code.ao.CodeOutSideUrlCUDAO;
import com.corn.vsound.web.code.ao.CodeParameterAO;
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

    @PostMapping("/codeParameterCUD")
    @RequestLog("源码参数CUD操作")
    public JsonResult codeParameterCUD(@RequestBody CodeParameterAO ao){
        CodeParameterCUDOrder order = new CodeParameterCUDOrder();
        BeanCopier.create(CodeParameterAO.class,CodeParameterCUDOrder.class,false).copy(ao,order,null);
        order.setSerialNo(AppUtils.appCode(""));

        CodeParameterCUDResult result = codeFacadeClient.codeParameterCUD(order);
        return new JsonResult(result);
    }

    @GetMapping("/codeParameterListQuery")
    @RequestLog("源码参数列表查询")
    public JsonResult codeParameterListQuery(String codeId){
        CodeParameterListQueryOrder order = new CodeParameterListQueryOrder();
        order.setCodeId(codeId);
        order.setSerialNo(AppUtils.appCode(""));

        CodeParameterListQueryResult result = codeFacadeClient.codeParameterListQuery(order);
        return new JsonResult(result);
    }

    @PostMapping("/codeOutSideUrlCUD")
    @RequestLog("源码外链CUD操作")
    public JsonResult codeOutSideUrlCUD(@RequestBody CodeOutSideUrlCUDAO ao){
        CodeOutSideUrlCUDOrder codeOutSideUrlCUDOrder = new CodeOutSideUrlCUDOrder();
        BeanCopier.create(ao.getClass(),codeOutSideUrlCUDOrder.getClass(),false).copy(ao,codeOutSideUrlCUDOrder,null);
        codeOutSideUrlCUDOrder.setSerialNo(AppUtils.appCode(""));

        CodeOutSideUrlCUDResult codeOutSideUrlCUDResult = codeFacadeClient.codeOutSideUrlCUD(codeOutSideUrlCUDOrder);
        return new JsonResult(codeOutSideUrlCUDResult);
    }

    @GetMapping("/codeOutSideUrlListQuery")
    @RequestLog("源码参数列表查询")
    public JsonResult codeOutSideUrlListQuery(String codeId){
        CodeOutSideUrlListQueryOrder order = new CodeOutSideUrlListQueryOrder();
        order.setCodeId(codeId);
        order.setSerialNo(AppUtils.appCode(""));

        CodeOutSideUrlListQueryResult result = codeFacadeClient.codeOutSideUrlListQuery(order);
        return new JsonResult(result);
    }
}
