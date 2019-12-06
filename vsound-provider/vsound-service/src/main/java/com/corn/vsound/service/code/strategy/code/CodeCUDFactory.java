package com.corn.vsound.service.code.strategy.code;


import com.corn.boot.base.factory.AbstractCUDFactory;
import com.corn.boot.error.BizError;
import com.corn.vsound.common.spring.SpringBeanUtils;
import com.corn.vsound.facade.code.order.CodeCUDOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CodeCUDFactory extends AbstractCUDFactory<CodeStrategyInterface, CodeCUDOrder> {

    @Autowired
    private SpringBeanUtils springBeanUtils;

    @Override
    public CodeStrategyInterface createStrategy(CodeCUDOrder order){

        if(CREATE_CODE.equals(order.getCudType())){
            return springBeanUtils.getApplicationContext().getBean(CodeCreateStrategy.class);
        }
        if(UPDATE_CODE.equals(order.getCudType())){
            return springBeanUtils.getApplicationContext().getBean(CodeUpdateStrategy.class);
        }
        if(DELETE_CODE.equals(order.getCudType())){
            return springBeanUtils.getApplicationContext().getBean(CodeDeleteStrategy.class);
        }
        throw new BizError("策略类型异常,请校验");
    };
}
