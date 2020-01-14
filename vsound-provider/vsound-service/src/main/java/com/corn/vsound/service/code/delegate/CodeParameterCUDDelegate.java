package com.corn.vsound.service.code.delegate;

import com.corn.boot.annotations.DoTranscation;
import com.corn.boot.base.AbstractBizService;
import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.vsound.facade.code.order.CodeParameterCUDOrder;
import com.corn.vsound.facade.code.result.CodeParameterCUDResult;
import com.corn.vsound.service.code.strategy.parameter.CodeParameterStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@DoTranscation
public class CodeParameterCUDDelegate extends AbstractBizService<CodeParameterCUDOrder, CodeParameterCUDResult> {

    @Autowired
    private CodeParameterStrategyFactory codeParameterStrategyFactory;

    @Override
    protected CodeParameterCUDResult initResult() {
        return new CodeParameterCUDResult();
    }

    @Override
    protected void orderCheck(CodeParameterCUDOrder order) {
        order.orderCheck();
        order.checkCUDParams();
    }

    @Override
    protected void appBiz(CodeParameterCUDOrder order, CodeParameterCUDResult result) {
        CudExecuteInterface baseCUDInterface = codeParameterStrategyFactory.createStrategy(order);
        baseCUDInterface.execute(order);

    }
}
