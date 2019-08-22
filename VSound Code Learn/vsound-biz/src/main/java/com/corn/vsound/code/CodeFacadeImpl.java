package com.corn.vsound.code;

import com.corn.vsound.code.create.CodeAddOrder;
import com.corn.vsound.code.create.CodeAddResult;
import com.corn.vsound.code.delegate.CodeAddDelegate;
import com.corn.vsound.code.delegate.CodeListQueryByKeyWordDelegate;
import com.corn.vsound.code.list.CodeListQueryByKeyWordOrder;
import com.corn.vsound.code.list.CodeListQueryByKeyWordResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CodeFacadeImpl implements CodeFacade {

    @Autowired
    private CodeListQueryByKeyWordDelegate codeListQueryByKeyWordDelegate;

    @Autowired
    private CodeAddDelegate codeAddDelegate;

    @Override
    public CodeListQueryByKeyWordResult codeListQueryByKeyWord(CodeListQueryByKeyWordOrder order) {
        return codeListQueryByKeyWordDelegate.execute("源码列表查询",order);
    }

    @Override
    public CodeAddResult codeAdd(CodeAddOrder order) {
        return codeAddDelegate.execute("源码新增",order);
    }
}
