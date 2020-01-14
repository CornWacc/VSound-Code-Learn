package com.corn.vsound.service.project.delegate;

import com.corn.boot.annotations.DoTranscation;
import com.corn.boot.base.AbstractBizService;
import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.boot.error.BizError;
import com.corn.vsound.facade.project.order.ProjectCUDOrder;
import com.corn.vsound.facade.project.result.ProjectCUDResult;
import com.corn.vsound.service.project.strategy.ProjectStrategyFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.curator.shaded.com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author yyc
 * @apiNote 项目增删改实现
 * */
@Service
@DoTranscation
public class ProjectCUDDelegate extends AbstractBizService<ProjectCUDOrder, ProjectCUDResult> {

    @Autowired
    private ProjectStrategyFactory projectStrategyFactory;

    @Override
    protected ProjectCUDResult initResult() {
        return new ProjectCUDResult();
    }

    @Override
    protected void orderCheck(ProjectCUDOrder order) {

        order.orderCheck();
        order.checkCUDParams();
    }

    @Override
    protected void appBiz(ProjectCUDOrder order, ProjectCUDResult result) {

        Map<String,Integer> map = Maps.newHashMap();
        //此处使用策略模式
        CudExecuteInterface baseCUDInterface = projectStrategyFactory.createStrategy(order);
        baseCUDInterface.execute(order);
    }
}
