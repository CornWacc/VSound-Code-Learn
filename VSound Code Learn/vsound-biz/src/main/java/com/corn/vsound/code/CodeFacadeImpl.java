package com.corn.vsound.code;

import com.corn.vsound.code.codeparam.CodeParamsAddOrder;
import com.corn.vsound.code.codeparam.CodeParamsAddResult;
import com.corn.vsound.code.create.CodeAddOrder;
import com.corn.vsound.code.create.CodeAddResult;
import com.corn.vsound.code.del.CodeDelOrder;
import com.corn.vsound.code.del.CodeDelResult;
import com.corn.vsound.code.delegate.*;
import com.corn.vsound.code.list.CodeListQueryByKeyWordOrder;
import com.corn.vsound.code.list.CodeListQueryByKeyWordResult;
import com.corn.vsound.code.update.CodeUpdateOrder;
import com.corn.vsound.code.update.CodeUpdateResult;
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
    private CodeParamsAddDelegate codeParamsAddDelegate;

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
    public CodeParamsAddResult codeParamsAdd(CodeParamsAddOrder order) {
        return codeParamsAddDelegate.execute("源码内容新增",order);
    }

    @Override
    public CodeUpdateResult codeUpdate(CodeUpdateOrder order) {
        return codeUpdateDelegate.execute("源码更新",order);
    }
}
