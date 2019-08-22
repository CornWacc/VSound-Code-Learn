package com.corn.vsound.code;

import com.corn.boot.base.JsonResult;
import com.corn.boot.util.AppUtils;
import com.corn.vsound.code.create.CodeAddOrder;
import com.corn.vsound.code.create.CodeAddResult;
import com.corn.vsound.code.list.CodeListQueryByKeyWordOrder;
import com.corn.vsound.code.list.CodeListQueryByKeyWordResult;
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
}
