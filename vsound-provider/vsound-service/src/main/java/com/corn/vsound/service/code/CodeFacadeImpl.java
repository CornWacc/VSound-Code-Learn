package com.corn.vsound.service.code;

import com.corn.vsound.facade.code.CodeFacade;
import com.corn.vsound.facade.code.order.*;
import com.corn.vsound.facade.code.result.*;
import com.corn.vsound.service.code.delegate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeFacadeImpl implements CodeFacade {

    @Autowired
    private CodeCUDDelegate codeCUDDelegate;

    @Autowired
    private CodeMethodCUDDelegate codeMethodCUDDelegate;

    @Autowired
    private CodeDetailQueryDelegate codeDetailQueryDelegate;

    @Autowired
    private CodeMethodListQueryDelegate codeMethodListQueryDelegate;

    @Autowired
    private CodeParameterListQueryDelegate codeParameterListQueryDelegate;

    @Autowired
    private CodeParameterCUDDelegate codeParameterCUDDelegate;

    @Autowired
    private CodeOutSideUrlCUDDelegate codeOutSideUrlCUDDelegate;

    @Autowired
    private CodeOutSideUrlListQueryDelegate codeOutSideUrlListQueryDelegate;

    @Autowired
    private CodeMethodOrderCUDDelegate codeMethodOrderCUDDelegate;

    @Override
    public CodeCUDResult codeCUD(CodeCUDOrder order) {
        return codeCUDDelegate.execute("源码CUD业务",order);
    }

    @Override
    public CodeMethodCUDResult codeMethodCUD(CodeMethodCUDOrder order) {
        return codeMethodCUDDelegate.execute("源码方法CUD业务",order);
    }

    @Override
    public CodeDetailQueryResult codeDetailQuery(CodeDetailQueryOrder order) {
        return codeDetailQueryDelegate.execute("源码详情查看",order);
    }

    @Override
    public CodeMethodListQueryResult codeMethodListQuery(CodeMethodListQueryOrder order) {
        return codeMethodListQueryDelegate.execute("源码方法列表查询",order);
    }

    @Override
    public CodeParameterCUDResult codeParameterCUD(CodeParameterCUDOrder order) {
        return codeParameterCUDDelegate.execute("源码参数CUD操作",order);
    }

    @Override
    public CodeParameterListQueryResult codeParameterListQuery(CodeParameterListQueryOrder order) {
        return codeParameterListQueryDelegate.execute("源码参数列表查询",order);
    }

    @Override
    public CodeOutSideUrlCUDResult codeOutSideUrlCUD(CodeOutSideUrlCUDOrder order) {
        return codeOutSideUrlCUDDelegate.execute("源码外链CUD操作",order);
    }

    @Override
    public CodeOutSideUrlListQueryResult codeOutSideUrlListQuery(CodeOutSideUrlListQueryOrder order) {
        return codeOutSideUrlListQueryDelegate.execute("源码外链列表查询",order);
    }

    @Override
    public CodeMethodOrderCUDResult codeMethodOrderCUD(CodeMethodOrderCUDOrder order) {
        return codeMethodOrderCUDDelegate.execute("源码方法入参CUD操作",order);
    }

}
