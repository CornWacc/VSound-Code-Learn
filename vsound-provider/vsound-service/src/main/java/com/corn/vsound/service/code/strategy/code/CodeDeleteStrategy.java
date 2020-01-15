package com.corn.vsound.service.code.strategy.code;

import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.entity.CodeBase;
import com.corn.vsound.dao.entity.CodeMethod;
import com.corn.vsound.dao.mapper.*;
import com.corn.vsound.facade.code.order.CodeCUDOrder;
import com.corn.vsound.facade.code.result.CodeCUDResult;
import com.corn.vsound.service.code.strategy.codemethod.CodeMethodDeleteStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CodeDeleteStrategy implements CudExecuteInterface<CodeCUDOrder, CodeCUDResult> {

    @Autowired
    private CodeBaseMapper codeBaseMapper;

    @Autowired
    private CodeMethodMapper codeMethodMapper;

    @Autowired
    private CodeParameterMapper codeParameterMapper;

    @Autowired
    private CodeOutSideUrlMapper codeOutSideUrlMapper;

    @Autowired
    private CodeMethodOrderMapper codeMethodOrderMapper;

    @Override
    public CodeCUDResult execute(CodeCUDOrder codeCUDOrder) {

        String codeId = codeCUDOrder.getCodeId();
        CodeBase codeBase = codeBaseMapper.findCodeBaseByCodeId(codeId);
        if(ObjectUtils.isEmpty(codeBase)){
            throw new BizError("该源码不存在,请刷新页面!");
        }

        codeBaseMapper.deleteByPrimaryKey(codeId);
        List<String> codeIds = Arrays.asList(codeId);

        List<CodeMethod> codeMethods = codeMethodMapper.findCodeMethodListByCodeId(codeIds);
        if(!ObjectUtils.isEmpty(codeMethods)){
            codeMethodMapper.deleteCodeMethodsByCodeIds(codeIds);
            codeMethodOrderMapper.batchDeleteMethodOrder(codeMethods.stream().map(CodeMethod::getMethodId).collect(Collectors.toList()));
        }

        codeParameterMapper.deleteCodeParametersByCodeIds(codeIds);
        codeOutSideUrlMapper.deleteCodeOutSideUrlsByCodeIds(codeIds);
        return new CodeCUDResult();
    }
}
