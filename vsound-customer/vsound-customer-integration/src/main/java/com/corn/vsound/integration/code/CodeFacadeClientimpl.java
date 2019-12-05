package com.corn.vsound.integration.code;


import com.corn.boot.annotations.Log;
import com.corn.vsound.facade.code.CodeFacade;
import com.corn.vsound.facade.code.order.CodeCUDOrder;
import com.corn.vsound.facade.code.result.CodeCUDResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeFacadeClientimpl implements CodeFacadeClient {

    @Autowired
    private CodeFacade codeFacade;

    @Override
    @Log(name = "源码业务",des = "源码CUD业务")
    public CodeCUDResult codeCUD(CodeCUDOrder order) {
        return codeFacade.codeCUD(order);
    }


}
