package com.corn.vsound.service.code.delegate;

import com.corn.boot.base.AbstractBizService;
import com.corn.vsound.dao.mapper.CodeBaseMapper;
import com.corn.vsound.facade.code.order.CodeCUDOrder;
import com.corn.vsound.facade.code.result.CodeCUDResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeCUDDelegate extends AbstractBizService<CodeCUDOrder, CodeCUDResult> {

    @Autowired
    private CodeBaseMapper codeBaseMapper;

    @Override
    protected CodeCUDResult initResult() {
        return new CodeCUDResult();
    }

    @Override
    protected void orderCheck(CodeCUDOrder order) {
        order.orderCheck();
    }

    @Override
    protected void appBiz(CodeCUDOrder order, CodeCUDResult result) {

    }
}
