package com.corn.vsound.service.code.strategy.codemethod;

import com.corn.boot.base.factory.AbstractCUDFactory;
import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.boot.error.BizError;
import com.corn.vsound.common.spring.SpringBeanUtils;
import com.corn.vsound.facade.code.order.CodeMethodCUDOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CodeMethodStrategyFactory extends AbstractCUDFactory<CudExecuteInterface, CodeMethodCUDOrder> {

    @Autowired
    private SpringBeanUtils springBeanUtils;

    @Override
    public CudExecuteInterface createStrategy(CodeMethodCUDOrder order) {

        String cudType = order.getCudType().getCode();
        ApplicationContext applicationContext = springBeanUtils.getApplicationContext();
        if(CREATE_CODE.equals(cudType)){
            return applicationContext.getBean(CodeMethodCreateStrategy.class);
        }

        if(UPDATE_CODE.equals(cudType)){
            return applicationContext.getBean(CodeMethodUpdateStrategy.class);
        }

        if(DELETE_CODE.equals(cudType)){
            return applicationContext.getBean(CodeMethodDeleteStrategy.class);
        }
        throw new BizError("策略类型异常,请校验");
    }
}
