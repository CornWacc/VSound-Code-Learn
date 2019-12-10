package com.corn.vsound.service.code.strategy.code;


import com.corn.boot.base.factory.AbstractCUDFactory;
import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.boot.error.BizError;
import com.corn.vsound.common.spring.SpringBeanUtils;
import com.corn.vsound.facade.code.order.CodeCUDOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CodeCUDFactory extends AbstractCUDFactory<BaseCUDInterface, CodeCUDOrder> {

    @Autowired
    private SpringBeanUtils springBeanUtils;

    @Override
    public BaseCUDInterface createStrategy(CodeCUDOrder order){

        String cudType = order.getCudType().getCode();
        if(CREATE_CODE.equals(cudType)){
            return springBeanUtils.getApplicationContext().getBean(CodeCreateStrategy.class);
        }
        if(UPDATE_CODE.equals(cudType)){
            return springBeanUtils.getApplicationContext().getBean(CodeUpdateStrategy.class);
        }
        if(DELETE_CODE.equals(cudType)){
            return springBeanUtils.getApplicationContext().getBean(CodeDeleteStrategy.class);
        }
        throw new BizError("策略类型异常,请校验");
    };
}
