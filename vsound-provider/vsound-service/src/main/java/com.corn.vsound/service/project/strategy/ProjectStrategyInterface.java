package com.corn.vsound.service.project.strategy;

import com.corn.vsound.facade.project.order.ProjectCUDOrder;

public interface ProjectStrategyInterface {

    void execute(ProjectCUDOrder order);

}
