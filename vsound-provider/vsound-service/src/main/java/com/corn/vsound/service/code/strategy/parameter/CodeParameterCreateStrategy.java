package com.corn.vsound.service.code.strategy.parameter;


import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.boot.util.DateUtils;
import com.corn.vsound.dao.entity.CodeParameter;
import com.corn.vsound.dao.mapper.CodeParameterMapper;
import com.corn.vsound.facade.code.order.CodeParameterCUDOrder;
import com.corn.vsound.facade.code.result.CodeParameterCUDResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author yyc
 * @apiNote
 * 2019/12/11
 * */
@Service
public class CodeParameterCreateStrategy implements CudExecuteInterface<CodeParameterCUDOrder, CodeParameterCUDResult> {

    @Autowired
    private CodeParameterMapper codeParameterMapper;

    @Override
    public CodeParameterCUDResult execute(CodeParameterCUDOrder order) {

        CodeParameter codeParameter = new CodeParameter();
        BeanCopier.create(CodeParameterCUDOrder.class,CodeParameter.class,false).copy(order,codeParameter,null);
        codeParameter.setParameterId("cp"+ DateUtils.dateForMateForConnect(new Date()));
        codeParameterMapper.insertSelective(codeParameter);

        return new CodeParameterCUDResult();
    }
}
