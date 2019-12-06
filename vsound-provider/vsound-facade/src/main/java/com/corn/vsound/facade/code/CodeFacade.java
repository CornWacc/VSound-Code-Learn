package com.corn.vsound.facade.code;

import com.corn.vsound.facade.code.order.CodeCUDOrder;
import com.corn.vsound.facade.code.order.CodeDetailQueryOrder;
import com.corn.vsound.facade.code.order.CodeMethodCUDOrder;
import com.corn.vsound.facade.code.result.CodeCUDResult;
import com.corn.vsound.facade.code.result.CodeDetailQueryResult;
import com.corn.vsound.facade.code.result.CodeMethodCUDResult;

public interface CodeFacade {

    CodeCUDResult codeCUD(CodeCUDOrder order);

    CodeMethodCUDResult codeMethodCUD(CodeMethodCUDOrder order);

    CodeDetailQueryResult codeDetailQuery(CodeDetailQueryOrder order);

}
