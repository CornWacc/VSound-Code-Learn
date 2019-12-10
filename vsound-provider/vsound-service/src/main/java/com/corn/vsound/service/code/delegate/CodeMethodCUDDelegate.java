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

@Service
@DoTranscation
public class CodeMethodCUDDelegate extends AbstractBizService<CodeMethodCUDOrder, CodeMethodCUDResult> {

    private static final String CREATE_CODE = "CREATE";

    @Autowired
    private CodeMethodMapper codeMethodMapper;

    @Autowired
    private CodeMethodStrategyFactory codeMethodStrategyFactory;

    @Override
    protected CodeMethodCUDResult initResult() {
        return new CodeMethodCUDResult();
    }

    @Override
    protected void orderCheck(CodeMethodCUDOrder order) {
        order.orderCheck();
        if(StringUtils.isBlank(order.getCudType())){
            throw new BizError("策略类型不能为空!");
        }

        if(!CREATE_CODE.equals(order.getCudType())){
            if(StringUtils.isBlank(order.getCodeMethodId())){
                throw new BizError("更新/删除策略->源码方法id不能为空!");
            }
        }
    }

    @Override
    protected void appBiz(CodeMethodCUDOrder order, CodeMethodCUDResult result) {

        BaseCUDInterface baseCUDInterface = codeMethodStrategyFactory.createStrategy(order);
        baseCUDInterface.execute(order);
    }
}
