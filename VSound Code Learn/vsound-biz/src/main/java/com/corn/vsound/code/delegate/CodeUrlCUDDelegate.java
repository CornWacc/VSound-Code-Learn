package com.corn.vsound.code.delegate;

import com.corn.boot.base.AbstractBizService;
import com.corn.vsound.base.CUDInterface;
import com.corn.vsound.code.url.CodeUrlCUDOrder;
import com.corn.vsound.code.url.CodeUrlCUDResult;

public class CodeUrlCUDDelegate extends AbstractBizService<CodeUrlCUDOrder, CodeUrlCUDResult> implements CUDInterface<CodeUrlCUDOrder> {
    @Override
    protected CodeUrlCUDResult initResult() {
        return null;
    }

    @Override
    protected void orderCheck(CodeUrlCUDOrder order) {

    }

    @Override
    protected void appBiz(CodeUrlCUDOrder order, CodeUrlCUDResult result) {

    }

    @Override
    public void add(CodeUrlCUDOrder order) {

    }

    @Override
    public void del(String id) {

    }

    @Override
    public void update(CodeUrlCUDOrder order) {

    }

}
