package com.corn.vsound.service.code;

import com.corn.vsound.facade.code.CodeFacade;
import com.corn.vsound.facade.code.order.CodeCUDOrder;
import com.corn.vsound.facade.code.order.CodeDetailQueryOrder;
import com.corn.vsound.facade.code.order.CodeMethodCUDOrder;
import com.corn.vsound.facade.code.order.CodeMethodListQueryOrder;
import com.corn.vsound.facade.code.result.CodeCUDResult;
import com.corn.vsound.facade.code.result.CodeDetailQueryResult;
import com.corn.vsound.facade.code.result.CodeMethodCUDResult;
import com.corn.vsound.facade.code.result.CodeMethodListQueryResult;
import com.corn.vsound.service.code.delegate.CodeCUDDelegate;
import com.corn.vsound.service.code.delegate.CodeDetailQueryDelegate;
import com.corn.vsound.service.code.delegate.CodeMethodCUDDelegate;
import com.corn.vsound.service.code.delegate.CodeMethodListQueryDelegate;
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
}
