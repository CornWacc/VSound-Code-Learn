package com.corn.vsound.integration.code;

import com.corn.vsound.facade.code.order.CodeCUDOrder;
import com.corn.vsound.facade.code.order.CodeDetailQueryOrder;
import com.corn.vsound.facade.code.order.CodeMethodCUDOrder;
import com.corn.vsound.facade.code.order.CodeMethodListQueryOrder;
import com.corn.vsound.facade.code.result.CodeCUDResult;
import com.corn.vsound.facade.code.result.CodeDetailQueryResult;
import com.corn.vsound.facade.code.result.CodeMethodCUDResult;
import com.corn.vsound.facade.code.result.CodeMethodListQueryResult;

public interface CodeFacadeClient {

    CodeCUDResult codeCUD(CodeCUDOrder order);

    CodeDetailQueryResult codeDetailQuery(CodeDetailQueryOrder order);

    CodeMethodCUDResult codeMethodCUD(CodeMethodCUDOrder order);

    CodeMethodListQueryResult codeMethodListQuery(CodeMethodListQueryOrder order);
}
