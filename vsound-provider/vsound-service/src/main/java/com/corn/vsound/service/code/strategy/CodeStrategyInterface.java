package com.corn.vsound.service.code.strategy;

import com.corn.vsound.facade.code.order.CodeCUDOrder;

public interface CodeStrategyInterface {

    void execute(CodeCUDOrder codeCUDOrder);

}
