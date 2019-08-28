package com.corn.vsound.code;

import com.corn.vsound.code.create.CodeAddOrder;
import com.corn.vsound.code.create.CodeAddResult;
import com.corn.vsound.code.del.CodeDelOrder;
import com.corn.vsound.code.del.CodeDelResult;
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


public interface CodeFacade {

    CodeListQueryByKeyWordResult codeListQueryByKeyWord(CodeListQueryByKeyWordOrder order);

    CodeAddResult codeAdd(CodeAddOrder order);

    CodeUpdateResult codeUpdate(CodeUpdateOrder order);

    CodeDelResult codeDel(CodeDelOrder order);

    CodeMethodCUDResult codeMethodCUD(CodeMethodCUDOrder order);

    CodeParameterCUDResult codeParameterCUD(CodeParameterCUDOrder order);

    CodeUrlCUDResult codeUrlCUD(CodeUrlCUDOrder order);
}

