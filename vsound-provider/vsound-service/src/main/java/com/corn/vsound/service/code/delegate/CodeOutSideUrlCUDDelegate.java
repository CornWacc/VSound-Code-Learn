package com.corn.vsound.service.code.delegate;

import com.corn.boot.base.AbstractBizService;
import com.corn.vsound.facade.code.order.CodeOutSideUrlCUDOrder;
import com.corn.vsound.facade.code.result.CodeOutSideUrlCUDResult;
import org.springframework.stereotype.Service;

/**
 * @author yyc
 * @apiNote
 * @createTime 2019/12/11
 */
@Service
public class CodeOutSideUrlCUDDelegate extends AbstractBizService<CodeOutSideUrlCUDOrder, CodeOutSideUrlCUDResult> {

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

    }
}
