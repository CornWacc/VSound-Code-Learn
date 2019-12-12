package com.corn.vsound.service.code.delegate;

import com.corn.boot.annotations.DoTranscation;
import com.corn.boot.base.AbstractBizService;
import com.corn.boot.base.factory.AbstractCUDFactory;
import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.mapper.CodeMethodMapper;
import com.corn.vsound.facade.code.order.CodeMethodCUDOrder;
import com.corn.vsound.facade.code.result.CodeMethodCUDResult;
import com.corn.vsound.service.code.strategy.codemethod.CodeMethodStrategyFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@DoTranscation
public class CodeMethodCUDDelegate extends AbstractBizService<CodeMethodCUDOrder, CodeMethodCUDResult> {

    @Autowired
    private CodeMethodStrategyFactory codeMethodStrategyFactory;

    @Override
    protected CodeMethodCUDResult initResult() {
        return new CodeMethodCUDResult();
    }

    @Override
    protected void orderCheck(CodeMethodCUDOrder order) {
        order.orderCheck();
        if(ObjectUtils.isEmpty(order.getCudType())){
            throw new BizError("策略类型不能为空!");
        }
        order.checkCUDParams();
    }

    @Override
    protected void appBiz(CodeMethodCUDOrder order, CodeMethodCUDResult result) {

        BaseCUDInterface baseCUDInterface = codeMethodStrategyFactory.createStrategy(order);
        baseCUDInterface.execute(order);
    }
}
