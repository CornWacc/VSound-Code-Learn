package com.corn.vsound.service.code.delegate;

import com.corn.boot.annotations.DoTranscation;
import com.corn.boot.base.AbstractBizService;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.mapper.CodeMethodMapper;
import com.corn.vsound.facade.code.order.CodeMethodCUDOrder;
import com.corn.vsound.facade.code.result.CodeMethodCUDResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@DoTranscation
public class CodeMethodCUDDelegate extends AbstractBizService<CodeMethodCUDOrder, CodeMethodCUDResult> {

    @Autowired
    private CodeMethodMapper codeMethodMapper;

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
    }

    @Override
    protected void appBiz(CodeMethodCUDOrder order, CodeMethodCUDResult result) {

    }
}
