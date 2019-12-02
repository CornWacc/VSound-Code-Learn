package com.corn.vsound.service.project.delegate;

import com.corn.boot.base.AbstractBizService;
import com.corn.boot.error.BizError;
import com.corn.vsound.facade.project.order.ProjectCUDOrder;
import com.corn.vsound.facade.project.result.ProjectCUDResult;
import com.corn.vsound.service.project.strategy.ProjectStrategyFactory;
import com.corn.vsound.service.project.strategy.ProjectStrategyInterface;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


/**
 * @author yyc
 * @apiNote 项目增删改实现
 * */
@Service
public class ProjectCUDDelegate extends AbstractBizService<ProjectCUDOrder, ProjectCUDResult> {

    @Autowired
    private ProjectStrategyFactory projectStrategyFactory;

    @Override
    protected ProjectCUDResult initResult() {
        return new ProjectCUDResult();
    }

    @Override
    protected void orderCheck(ProjectCUDOrder order) {

        if(StringUtils.isBlank(order.getCudType())){
            throw new BizError("操作类型不能为空！");
        }
        order.orderCheck();
    }

    @Override
    protected void appBiz(ProjectCUDOrder order, ProjectCUDResult result) {

        //此处使用策略模式
        ProjectStrategyInterface projectStrategyInterface = projectStrategyFactory.createProjectStrategy(order.getCudType());

        if(ObjectUtils.isEmpty(projectStrategyInterface)){
            throw new BizError("策略类型异常,请校验");
        }
        projectStrategyInterface.execute(order);
    }
}
