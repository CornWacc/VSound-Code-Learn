package com.corn.vsound.service.project.strategy;

import com.corn.boot.base.factory.AbstractCUDFactory;
import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.boot.error.BizError;
import com.corn.vsound.common.spring.SpringBeanUtils;
import com.corn.vsound.facade.project.order.ProjectCUDOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectStrategyFactory extends AbstractCUDFactory<CudExecuteInterface, ProjectCUDOrder> {

     @Autowired
    private SpringBeanUtils springBeanUtils;

    @Override
    public CudExecuteInterface createStrategy(ProjectCUDOrder order) {
        String cudType = order.getCudType().getCode();
        if(CREATE_CODE.equals(cudType)){
            return springBeanUtils.getApplicationContext().getBean(ProjectCreateStrategy.class);
        }

        if(UPDATE_CODE.equals(cudType)){
            return springBeanUtils.getApplicationContext().getBean(ProjectUpdateStrategy.class);
        }

        if(DELETE_CODE.equals(cudType)){
            return springBeanUtils.getApplicationContext().getBean(ProjectDelStrategy.class);
        }
        throw new BizError("策略类型异常,请校验");
    }
}
