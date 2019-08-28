package com.corn.vsound.code.delegate;

import com.corn.boot.base.AbstractBizService;
import com.corn.vsound.base.CUDInterface;
import com.corn.vsound.code.parameter.CodeParameterCUDOrder;
import com.corn.vsound.code.parameter.CodeParameterCUDResult;

public class CodeParameterCUDDelegate extends AbstractBizService<CodeParameterCUDOrder, CodeParameterCUDResult> implements CUDInterface<CodeParameterCUDOrder> {
    @Override
    protected CodeParameterCUDResult initResult() {
        return null;
    }

    @Override
    protected void orderCheck(CodeParameterCUDOrder order) {

    }

    @Override
    protected void appBiz(CodeParameterCUDOrder order, CodeParameterCUDResult result) {

    }

    @Override
    public void add(CodeParameterCUDOrder order) {

    }

    @Override
    public void del(String id) {

    }

    @Override
    public void update(CodeParameterCUDOrder order) {

    }

}
