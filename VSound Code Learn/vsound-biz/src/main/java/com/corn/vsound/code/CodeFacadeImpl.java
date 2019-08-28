package com.corn.vsound.code;

import com.corn.vsound.code.create.CodeAddOrder;
import com.corn.vsound.code.create.CodeAddResult;
import com.corn.vsound.code.del.CodeDelOrder;
import com.corn.vsound.code.del.CodeDelResult;
import com.corn.vsound.code.delegate.*;
import com.corn.vsound.code.list.CodeListQueryByKeyWordOrder;
import com.corn.vsound.code.list.CodeListQueryByKeyWordResult;
import com.corn.vsound.code.method.CodeMethodCUDOrder;
import com.corn.vsound.code.method.CodeMethodCUDResult;
import com.corn.vsound.code.parameter.CodeParameterCUDOrder;
import com.corn.vsound.code.parameter.CodeParameterCUDResult;
import com.corn.vsound.code.update.CodeUpdateOrder;
import com.corn.vsound.code.update.CodeUpdateResult;
import com.corn.vsound.code.url.CodeUrlCUDOrder;
import com.corn.vsound.code.url.CodeUrlCUDResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CodeFacadeImpl implements CodeFacade {

    @Autowired
    private CodeListQueryByKeyWordDelegate codeListQueryByKeyWordDelegate;

    @Autowired
    private CodeAddDelegate codeAddDelegate;

    @Autowired
    private CodeDelDelegate codeDelDelegate;

    @Autowired
    private CodeUpdateDelegate codeUpdateDelegate;

    @Autowired
    private CodeMethodCUDDelegate codeMethodCUDDelegate;

    @Override
    public CodeListQueryByKeyWordResult codeListQueryByKeyWord(CodeListQueryByKeyWordOrder order) {
        return codeListQueryByKeyWordDelegate.execute("源码列表查询",order);
    }

    @Override
    public CodeAddResult codeAdd(CodeAddOrder order) {
        return codeAddDelegate.execute("源码新增",order);
    }

    @Override
    public CodeDelResult codeDel(CodeDelOrder order) {
        return codeDelDelegate.execute("源码删除",order);
    }

    @Override
    public CodeMethodCUDResult codeMethodCUD(CodeMethodCUDOrder order) {
        return codeMethodCUDDelegate.execute("源码方法增删改",order);
    }

    @Override
    public CodeParameterCUDResult codeParameterCUD(CodeParameterCUDOrder order) {
        return null;
    }

    @Override
    public CodeUrlCUDResult codeUrlCUD(CodeUrlCUDOrder order) {
        return null;
    }

    @Override
    public CodeUpdateResult codeUpdate(CodeUpdateOrder order) {
        return codeUpdateDelegate.execute("源码更新",order);
    }
}
