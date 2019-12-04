package com.corn.vsound.facade.code;

import com.corn.vsound.facade.code.order.CodeCUDOrder;
import com.corn.vsound.facade.code.result.CodeCUDResult;

public interface CodeFacade {

    CodeCUDResult codeCUD(CodeCUDOrder order);

}
