package com.corn.vsound.code;

import com.corn.vsound.code.create.CodeAddOrder;
import com.corn.vsound.code.create.CodeAddResult;
import com.corn.vsound.code.list.CodeListQueryByKeyWordOrder;
import com.corn.vsound.code.list.CodeListQueryByKeyWordResult;

public interface CodeFacade {

    CodeListQueryByKeyWordResult codeListQueryByKeyWord(CodeListQueryByKeyWordOrder order);

    CodeAddResult codeAdd(CodeAddOrder order);
}
