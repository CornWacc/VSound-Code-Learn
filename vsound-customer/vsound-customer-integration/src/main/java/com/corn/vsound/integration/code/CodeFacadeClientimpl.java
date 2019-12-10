package com.corn.vsound.integration.code;


import com.corn.boot.annotations.Log;
import com.corn.vsound.facade.code.CodeFacade;
import com.corn.vsound.facade.code.order.CodeCUDOrder;
import com.corn.vsound.facade.code.order.CodeDetailQueryOrder;
import com.corn.vsound.facade.code.order.CodeMethodCUDOrder;
import com.corn.vsound.facade.code.order.CodeMethodListQueryOrder;
import com.corn.vsound.facade.code.result.CodeCUDResult;
import com.corn.vsound.facade.code.result.CodeDetailQueryResult;
import com.corn.vsound.facade.code.result.CodeMethodCUDResult;
import com.corn.vsound.facade.code.result.CodeMethodListQueryResult;
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


}
