package com.corn.vsound.service.code;

import com.corn.vsound.facade.code.CodeFacade;
import com.corn.vsound.facade.code.order.CodeCUDOrder;
import com.corn.vsound.facade.code.result.CodeCUDResult;
import org.springframework.stereotype.Service;

@Service
public class CodeFacadeImpl implements CodeFacade {

    @Override
    public CodeCUDResult codeCUD(CodeCUDOrder order) {
        return null;
    }
}
