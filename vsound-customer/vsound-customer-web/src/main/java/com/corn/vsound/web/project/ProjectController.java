package com.corn.vsound.web.project;


import com.corn.boot.base.JsonResult;
import com.corn.boot.util.AppUtils;
import com.corn.vsound.facade.project.order.ProjectCUDOrder;
import com.corn.vsound.facade.project.order.ProjectListQueryOrder;
import com.corn.vsound.facade.project.result.ProjectCUDResult;
import com.corn.vsound.facade.project.result.ProjectListQueryResult;
import com.corn.vsound.integration.projcet.ProjectFacadeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/project")
@RestController
public class ProjectController  {

    @Autowired
    private ProjectFacadeClient projectFacadeClient;

    @GetMapping("/projectListQuery")
    public JsonResult projectListQuery(){

        ProjectListQueryOrder order = new ProjectListQueryOrder();
//        order.setKeyWord();
        order.setSerialNo(AppUtils.appCode(""));

        ProjectListQueryResult result = projectFacadeClient.projectListQuery(order);
        return new JsonResult(result);
    }

    @PostMapping("/projectCUD")
    public JsonResult projectCUD(){
        ProjectCUDOrder order = new ProjectCUDOrder();
        order.setSerialNo(AppUtils.appCode(""));

        ProjectCUDResult result = projectFacadeClient.projectCUD(order);
        return new JsonResult(result);
    }

}
