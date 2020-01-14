package com.corn.vsound.service.code.strategy.outsideurl;

import com.corn.boot.base.factory.AbstractCUDFactory;
import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.vsound.common.spring.SpringBeanUtils;
import com.corn.vsound.facade.code.order.CodeOutSideUrlCUDOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yyc
 * @apiNote
 * @createTime 2019/12/12
 */
@Service
public class CodeOutSideUrlStrategyFactory extends AbstractCUDFactory<CudExecuteInterface, CodeOutSideUrlCUDOrder> {

    @Autowired
    private SpringBeanUtils springBeanUtils;

    @Override
    public CudExecuteInterface createStrategy(CodeOutSideUrlCUDOrder order) {

        String cudType = order.getCudType().getCode();

        if (CREATE_CODE.equals(cudType)) {
            return springBeanUtils.getApplicationContext().getBean(CodeOutSideUrlCreateStrategy.class);
        }
        if (UPDATE_CODE.equals(cudType)) {
            return springBeanUtils.getApplicationContext().getBean(CodeOutSideUrlUpdateStrategy.class);
        }
        if (DELETE_CODE.equals(cudType)) {
            return springBeanUtils.getApplicationContext().getBean(CodeOutSideUrlDeleteStrategy.class);
        }
        return null;
    }
}
