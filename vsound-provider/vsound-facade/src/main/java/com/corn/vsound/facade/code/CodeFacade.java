package com.corn.vsound.facade.code;

import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.boot.base.strategy.CUDOrder;
import com.corn.vsound.facade.code.order.*;
import com.corn.vsound.facade.code.result.*;

public interface CodeFacade {

    CodeCUDResult codeCUD(CodeCUDOrder order);

    CodeMethodCUDResult codeMethodCUD(CodeMethodCUDOrder order);

    CodeDetailQueryResult codeDetailQuery(CodeDetailQueryOrder order);

    CodeMethodListQueryResult codeMethodListQuery(CodeMethodListQueryOrder order);

    CodeParameterCUDResult codeParameterCUD(CodeParameterCUDOrder order);

    CodeParameterListQueryResult codeParameterListQuery(CodeParameterListQueryOrder order);
}
