package com.corn.vsound.service.code.delegate;

import com.corn.boot.annotations.DoTranscation;
import com.corn.boot.base.AbstractBizService;
import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.vsound.facade.code.order.CodeOutSideUrlCUDOrder;
import com.corn.vsound.facade.code.result.CodeOutSideUrlCUDResult;
import com.corn.vsound.service.code.strategy.outsideurl.CodeOutSideUrlStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yyc
 * @apiNote
 * @createTime 2019/12/11
 */
@Service
@DoTranscation
public class CodeOutSideUrlCUDDelegate extends AbstractBizService<CodeOutSideUrlCUDOrder, CodeOutSideUrlCUDResult> {

    @Autowired
    private CodeOutSideUrlStrategyFactory codeOutSideUrlStrategyFactory;

    @Override
    protected CodeOutSideUrlCUDResult initResult() {
        return new CodeOutSideUrlCUDResult();
    }

    @Override
    protected void orderCheck(CodeOutSideUrlCUDOrder order) {
        order.orderCheck();
        order.checkCUDParams();
    }

    @Override
    protected void appBiz(CodeOutSideUrlCUDOrder order, CodeOutSideUrlCUDResult result) {
        CudExecuteInterface baseCUDInterface = codeOutSideUrlStrategyFactory.createStrategy(order);
        baseCUDInterface.execute(order);
    }
}
