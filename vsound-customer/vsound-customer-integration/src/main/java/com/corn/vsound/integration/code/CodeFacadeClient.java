package com.corn.vsound.integration.code;

import com.corn.vsound.facade.code.order.*;
import com.corn.vsound.facade.code.result.*;

public interface CodeFacadeClient {

    CodeCUDResult codeCUD(CodeCUDOrder order);

    CodeDetailQueryResult codeDetailQuery(CodeDetailQueryOrder order);

    CodeMethodCUDResult codeMethodCUD(CodeMethodCUDOrder order);

    CodeMethodListQueryResult codeMethodListQuery(CodeMethodListQueryOrder order);

    CodeParameterCUDResult codeParameterCUD(CodeParameterCUDOrder order);

    CodeParameterListQueryResult codeParameterListQuery(CodeParameterListQueryOrder order);

    CodeOutSideUrlCUDResult codeOutSideUrlCUD(CodeOutSideUrlCUDOrder order);

    CodeOutSideUrlListQueryResult codeOutSideUrlListQuery(CodeOutSideUrlListQueryOrder order);

    CodeMethodOrderCUDResult codeMethodOrderCUD(CodeMethodOrderCUDOrder orderCUDOrder);
}
