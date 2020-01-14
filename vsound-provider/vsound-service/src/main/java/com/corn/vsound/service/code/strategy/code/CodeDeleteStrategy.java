package com.corn.vsound.service.code.strategy.code;

import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.entity.CodeBase;
import com.corn.vsound.dao.mapper.CodeBaseMapper;
import com.corn.vsound.dao.mapper.CodeMethodMapper;
import com.corn.vsound.dao.mapper.CodeOutSideUrlMapper;
import com.corn.vsound.dao.mapper.CodeParameterMapper;
import com.corn.vsound.facade.code.order.CodeCUDOrder;
import com.corn.vsound.facade.code.result.CodeCUDResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;

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

    @Override
    public CodeCUDResult execute(CodeCUDOrder codeCUDOrder) {

        String codeId = codeCUDOrder.getCodeId();
        CodeBase codeBase = codeBaseMapper.findCodeBaseByCodeId(codeId);
        if(ObjectUtils.isEmpty(codeBase)){
            throw new BizError("该源码不存在,请刷新页面!");
        }

        codeBaseMapper.deleteByPrimaryKey(codeId);

        List<String> codeIds = Arrays.asList(codeId);
        codeMethodMapper.deleteCodeMethodsByCodeIds(codeIds);
        codeParameterMapper.deleteCodeParametersByCodeIds(codeIds);
        codeOutSideUrlMapper.deleteCodeOutSideUrlsByCodeIds(codeIds);
        return new CodeCUDResult();
    }


}
