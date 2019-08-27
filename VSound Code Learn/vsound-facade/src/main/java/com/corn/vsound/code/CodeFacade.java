package com.corn.vsound.code;

import com.corn.vsound.code.codeparam.CodeParamsAddOrder;
import com.corn.vsound.code.codeparam.CodeParamsAddResult;
import com.corn.vsound.code.create.CodeAddOrder;
import com.corn.vsound.code.create.CodeAddResult;
import com.corn.vsound.code.del.CodeDelOrder;
import com.corn.vsound.code.del.CodeDelResult;
import com.corn.vsound.code.list.CodeListQueryByKeyWordOrder;
import com.corn.vsound.code.list.CodeListQueryByKeyWordResult;
import com.corn.vsound.code.update.CodeUpdateOrder;
import com.corn.vsound.code.update.CodeUpdateResult;


public interface CodeFacade {

    CodeListQueryByKeyWordResult codeListQueryByKeyWord(CodeListQueryByKeyWordOrder order);

    CodeAddResult codeAdd(CodeAddOrder order);

    CodeUpdateResult codeUpdate(CodeUpdateOrder order);

    CodeDelResult codeDel(CodeDelOrder order);

    CodeParamsAddResult codeParamsAdd(CodeParamsAddOrder order);
}

