package com.corn.vsound.code;

import com.corn.boot.base.JsonResult;
import com.corn.boot.util.AppUtils;
import com.corn.vsound.code.create.CodeAddOrder;
import com.corn.vsound.code.create.CodeAddResult;
import com.corn.vsound.code.del.CodeDelOrder;
import com.corn.vsound.code.del.CodeDelResult;
import com.corn.vsound.code.list.CodeListQueryByKeyWordOrder;
import com.corn.vsound.code.list.CodeListQueryByKeyWordResult;
import com.corn.vsound.code.method.CodeMethodCUDOrder;
import com.corn.vsound.code.method.CodeMethodCUDResult;
import com.corn.vsound.code.parameter.CodeParameterCUDOrder;
import com.corn.vsound.code.parameter.CodeParameterCUDResult;
import com.corn.vsound.code.update.CodeUpdateOrder;
import com.corn.vsound.code.update.CodeUpdateResult;
import com.corn.vsound.code.url.CodeUrlCUDOrder;
import com.corn.vsound.code.url.CodeUrlCUDResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/base/code")
@RestController
public class CodeController  {

    @Autowired
    private CodeFacade codeFacade;

    @GetMapping("codeInfoQuery")
    public JsonResult codeInfoQuery(CodeListQueryByKeyWordOrder order){
        order.setSerialNo(AppUtils.appCode("codeInfoQuery"));
        CodeListQueryByKeyWordResult result = codeFacade.codeListQueryByKeyWord(order);
        return new JsonResult(result);
    }

    @PostMapping("codeAdd")
    public JsonResult codeAdd(@RequestBody CodeAddOrder order){
        order.setSerialNo(AppUtils.appCode("codeAdd"));
        CodeAddResult result = codeFacade.codeAdd(order);
        return new JsonResult(result);
    }

    @PostMapping("delCode")
    public JsonResult codeDel(@RequestBody CodeDelOrder order){
        order.setSerialNo(AppUtils.appCode("codeDell"));
        CodeDelResult result = codeFacade.codeDel(order);
        return new JsonResult(result);
    }

    @PostMapping("codeUpdate")
    public JsonResult codeUpdate(@RequestBody CodeUpdateOrder order){
        order.setSerialNo(AppUtils.appCode("codeUpdate"));
        CodeUpdateResult result = codeFacade.codeUpdate(order);
        return new JsonResult(result);
    }

    @PostMapping("codeMethodCUD")
    public JsonResult codeMethodCUD(@RequestBody CodeMethodCUDOrder order){
        order.setSerialNo(AppUtils.appCode("codeMethodCUD"));
        CodeMethodCUDResult result = codeFacade.codeMethodCUD(order);
        return new JsonResult(result);
    }

    @PostMapping("codeParameterCUD")
    public JsonResult codeParameterCUD(@RequestBody CodeParameterCUDOrder order){
        order.setSerialNo(AppUtils.appCode("codeParameterCUD"));
        CodeParameterCUDResult result = codeFacade.codeParameterCUD(order);
        return new JsonResult(result);
    }

    @PostMapping("codeUrlCUD")
    public JsonResult codeUrlCUD(@RequestBody CodeUrlCUDOrder order){
        order.setSerialNo(AppUtils.appCode("codeUrlCUD"));
        CodeUrlCUDResult result = codeFacade.codeUrlCUD(order);
        return new JsonResult(result);
    }
}
