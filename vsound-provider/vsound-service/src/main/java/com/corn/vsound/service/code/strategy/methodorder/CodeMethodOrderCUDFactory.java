package com.corn.vsound.service.code.strategy.methodorder;

import com.corn.boot.base.factory.AbstractCUDFactory;
import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.boot.error.BizError;
import com.corn.vsound.common.spring.SpringBeanUtils;
import com.corn.vsound.facade.code.order.CodeMethodOrderCUDOrder;
import com.corn.vsound.service.code.strategy.code.CodeCreateStrategy;
import com.corn.vsound.service.code.strategy.code.CodeDeleteStrategy;
import com.corn.vsound.service.code.strategy.code.CodeUpdateStrategy;
import com.corn.vsound.service.code.strategy.codemethod.CodeMethodUpdateStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yyc
 * @apiNote 源码方法入参CUD操作转发
 * @createTime 2020/1/9
 */
@Service
public class CodeMethodOrderCUDFactory extends AbstractCUDFactory<BaseCUDInterface,CodeMethodOrderCUDOrder> {

    @Autowired
    private SpringBeanUtils springBeanUtils;

    @Override
    public BaseCUDInterface createStrategy(CodeMethodOrderCUDOrder order) {

        String cudType = order.getCudType().getCode();
        if(CREATE_CODE.equals(cudType)){
            return springBeanUtils.getApplicationContext().getBean(CodeMethodOrderCreateStrategy.class);
        }
        if(UPDATE_CODE.equals(cudType)){
            return springBeanUtils.getApplicationContext().getBean(CodeMethodOrderUpdateStrategy.class);
        }
        if(DELETE_CODE.equals(cudType)){
            return springBeanUtils.getApplicationContext().getBean(CodeMethodOrderDeleteStrategy.class);
        }
        throw new BizError("策略类型异常,请校验");
    }
}
