package com.corn.vsound.service.code.delegate;

import com.corn.boot.annotations.DoTranscation;
import com.corn.boot.base.AbstractBizService;
import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.boot.error.BizError;
import com.corn.vsound.facade.code.order.CodeCUDOrder;
import com.corn.vsound.facade.code.result.CodeCUDResult;
import com.corn.vsound.service.code.strategy.code.CodeCUDFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@DoTranscation
public class CodeCUDDelegate extends AbstractBizService<CodeCUDOrder, CodeCUDResult> {

    private static final String CREATE_CODE = "CREATE";

    @Autowired
    private CodeCUDFactory codeCUDFactory;

    @Override
    protected CodeCUDResult initResult() {
        return new CodeCUDResult();
    }

    @Override
    protected void orderCheck(CodeCUDOrder order) {
        order.orderCheck();
        order.checkCUDParams();

    }

    @Override
    protected void appBiz(CodeCUDOrder order, CodeCUDResult result) {
        BaseCUDInterface codeStrategyInterface = codeCUDFactory.createStrategy(order);
        codeStrategyInterface.execute(order);
    }
}
