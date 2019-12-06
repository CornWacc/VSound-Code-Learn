package com.corn.vsound.service.code.delegate;

import com.corn.boot.annotations.DoTranscation;
import com.corn.boot.base.AbstractBizService;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.mapper.CodeBaseMapper;
import com.corn.vsound.facade.code.order.CodeCUDOrder;
import com.corn.vsound.facade.code.result.CodeCUDResult;
import com.corn.vsound.service.code.strategy.code.CodeCUDFactory;
import com.corn.vsound.service.code.strategy.code.CodeStrategyInterface;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@DoTranscation
public class CodeCUDDelegate extends AbstractBizService<CodeCUDOrder, CodeCUDResult> {

    @Autowired
    private CodeBaseMapper codeBaseMapper;

    @Autowired
    private CodeCUDFactory codeCUDFactory;

    @Override
    protected CodeCUDResult initResult() {
        return new CodeCUDResult();
    }

    @Override
    protected void orderCheck(CodeCUDOrder order) {
        order.orderCheck();
        if(StringUtils.isBlank(order.getCudType())){
            throw new BizError("策略类型不能为空!");
        }
    }

    @Override
    protected void appBiz(CodeCUDOrder order, CodeCUDResult result) {
        CodeStrategyInterface codeStrategyInterface = codeCUDFactory.createStrategy(order);
        codeStrategyInterface.execute(order);
    }
}
