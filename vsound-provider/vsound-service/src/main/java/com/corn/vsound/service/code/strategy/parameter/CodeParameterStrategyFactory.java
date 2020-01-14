package com.corn.vsound.service.code.strategy.parameter;

import com.corn.boot.base.factory.AbstractCUDFactory;
import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.vsound.common.spring.SpringBeanUtils;
import com.corn.vsound.facade.code.order.CodeParameterCUDOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yyc
 * */
@Service
public class CodeParameterStrategyFactory extends AbstractCUDFactory<CudExecuteInterface, CodeParameterCUDOrder> {

    @Autowired
    private SpringBeanUtils springBeanUtils;

    @Override
    public CudExecuteInterface createStrategy(CodeParameterCUDOrder order) {
        String cudType = order.getCudType().getCode();
        if(CREATE_CODE.equals(cudType)){
            return springBeanUtils.getApplicationContext().getBean(CodeParameterCreateStrategy.class);
        }
        if(UPDATE_CODE.equals(cudType)){
            return springBeanUtils.getApplicationContext().getBean(CodeParameterUpdateStrategy.class);
        }
        if(DELETE_CODE.equals(cudType)){
            return springBeanUtils.getApplicationContext().getBean(CodeParameterDeleteStrategy.class);
        }
        return null;
    }
}
