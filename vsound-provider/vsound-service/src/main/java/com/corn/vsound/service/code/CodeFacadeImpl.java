package com.corn.vsound.service.code;

import com.corn.vsound.facade.code.CodeFacade;
import com.corn.vsound.facade.code.order.CodeCUDOrder;
import com.corn.vsound.facade.code.result.CodeCUDResult;
import com.corn.vsound.service.code.delegate.CodeCUDDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeFacadeImpl implements CodeFacade {

    @Autowired
    private CodeCUDDelegate codeCUDDelegate;

    @Override
    public CodeCUDResult codeCUD(CodeCUDOrder order) {
        return codeCUDDelegate.execute("源码CUD业务",order);
    }
}
