package com.corn.vsound.service.code.strategy.code;


import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.boot.util.DateUtils;
import com.corn.vsound.dao.entity.CodeBase;
import com.corn.vsound.dao.mapper.CodeBaseMapper;
import com.corn.vsound.facade.code.order.CodeCUDOrder;
import com.corn.vsound.facade.code.result.CodeCUDResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CodeCreateStrategy implements CudExecuteInterface<CodeCUDOrder, CodeCUDResult> {

    @Autowired
    private CodeBaseMapper codeBaseMapper;


    @Override
    public CodeCUDResult execute(CodeCUDOrder codeCUDOrder) {

        CodeBase codeBase = new CodeBase();
        BeanCopier.create(CodeCUDOrder.class,CodeBase.class,false).copy(codeCUDOrder,codeBase,null);
        codeBase.setCodeId("code"+DateUtils.dateForMateForConnect(new Date()));
        codeBaseMapper.insertSelective(codeBase);
        return new CodeCUDResult();
    }
}
