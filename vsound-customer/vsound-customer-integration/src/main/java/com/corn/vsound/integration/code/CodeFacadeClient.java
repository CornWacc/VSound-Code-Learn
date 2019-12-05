package com.corn.vsound.integration.code;

import com.corn.vsound.facade.code.order.CodeCUDOrder;
import com.corn.vsound.facade.code.result.CodeCUDResult;

public interface CodeFacadeClient {

    CodeCUDResult codeCUD(CodeCUDOrder order);

}
