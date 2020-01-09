package com.corn.vsound.integration.code;


import com.corn.boot.annotations.Log;
import com.corn.vsound.facade.code.CodeFacade;
import com.corn.vsound.facade.code.order.*;
import com.corn.vsound.facade.code.result.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeFacadeClientimpl implements CodeFacadeClient {

    @Autowired
    private CodeFacade codeFacade;

    @Override
    @Log(name = "源码业务",des = "源码CUD业务")
    public CodeCUDResult codeCUD(CodeCUDOrder order) {
        return codeFacade.codeCUD(order);
    }

    @Override
    @Log(name = "源码业务",des = "源码详情查看业务")
    public CodeDetailQueryResult codeDetailQuery(CodeDetailQueryOrder order) {
        return codeFacade.codeDetailQuery(order);
    }

    @Override
    @Log(name = "源码业务",des = "源码方法CUD业务")
    public CodeMethodCUDResult codeMethodCUD(CodeMethodCUDOrder order) {
        return codeFacade.codeMethodCUD(order);
    }

    @Override
    @Log(name = "源码业务",des = "源码方法列表查询")
    public CodeMethodListQueryResult codeMethodListQuery(CodeMethodListQueryOrder order) {
        return codeFacade.codeMethodListQuery(order);
    }

    @Override
    @Log(name = "源码服务",des = "源码参数CUD操作")
    public CodeParameterCUDResult codeParameterCUD(CodeParameterCUDOrder order) {
        return codeFacade.codeParameterCUD(order);
    }

    @Override
    @Log(name = "源码服务",des = "源码参数列表查询")
    public CodeParameterListQueryResult codeParameterListQuery(CodeParameterListQueryOrder order) {
        return codeFacade.codeParameterListQuery(order);
    }

    @Override
    @Log(name = "源码服务",des = "源码外链CUD操作")
    public CodeOutSideUrlCUDResult codeOutSideUrlCUD(CodeOutSideUrlCUDOrder order) {
        return codeFacade.codeOutSideUrlCUD(order);
    }

    @Override
    @Log(name = "源码服务",des = "源码外链列表查询")
    public CodeOutSideUrlListQueryResult codeOutSideUrlListQuery(CodeOutSideUrlListQueryOrder order) {
        return codeFacade.codeOutSideUrlListQuery(order);
    }

    @Override
    @Log(name = "源码服务",des = "源码方法入参CUD操作")
    public CodeMethodOrderCUDResult codeMethodOrderCUD(CodeMethodOrderCUDOrder orderCUDOrder) {
        return codeFacade.codeMethodOrderCUD(orderCUDOrder);
    }
}
