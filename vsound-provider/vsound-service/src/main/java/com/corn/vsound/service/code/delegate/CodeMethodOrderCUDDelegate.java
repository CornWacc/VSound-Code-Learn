package com.corn.vsound.service.code.delegate;

import com.corn.boot.base.AbstractBizService;
import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.vsound.facade.code.order.CodeMethodOrderCUDOrder;
import com.corn.vsound.facade.code.result.CodeMethodCUDResult;
import com.corn.vsound.facade.code.result.CodeMethodOrderCUDResult;
import com.corn.vsound.service.code.strategy.methodorder.CodeMethodOrderCUDFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yyc
 * @apiNote 源码方法入参CUD操作
 * @createTime 2020/1/9
 */
@Service
public class CodeMethodOrderCUDDelegate extends AbstractBizService<CodeMethodOrderCUDOrder, CodeMethodOrderCUDResult> {

    @Autowired
    private CodeMethodOrderCUDFactory codeMethodOrderCUDFactory;

    @Override
    protected CodeMethodOrderCUDResult initResult() {
        return new CodeMethodOrderCUDResult();
    }

    @Override
    protected void orderCheck(CodeMethodOrderCUDOrder order) {
        order.orderCheck();
        order.checkCUDParams();
    }

    @Override
    protected void appBiz(CodeMethodOrderCUDOrder order, CodeMethodOrderCUDResult result) {

        CudExecuteInterface baseCUDInterface = codeMethodOrderCUDFactory.createStrategy(order);
        baseCUDInterface.execute(order);
    }
}
