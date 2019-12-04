package com.corn.vsound.web.project;


import com.corn.boot.base.JsonResult;
import com.corn.boot.base.page.PageParamInfo;
import com.corn.boot.util.AppUtils;
import com.corn.vsound.facade.project.order.ProjectCUDOrder;
import com.corn.vsound.facade.project.order.ProjectListQueryOrder;
import com.corn.vsound.facade.project.order.ProjectQueryOrder;
import com.corn.vsound.facade.project.result.ProjectCUDResult;
import com.corn.vsound.facade.project.result.ProjectListQueryResult;
import com.corn.vsound.facade.project.result.ProjectQueryResult;
import com.corn.vsound.integration.projcet.ProjectFacadeClient;
import com.corn.vsound.web.account.AccountCache;
import com.corn.vsound.web.project.ao.ProjectCUDAO;
import com.corn.vsound.web.project.ao.ProjectListQueryAO;
import com.corn.vsound.web.project.ao.ProjectQueryAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/project")
@RestController
public class ProjectController  {

    @Autowired
    private ProjectFacadeClient projectFacadeClient;

    @GetMapping("/projectListQuery")
    public JsonResult projectListQuery(ProjectListQueryAO ao){

        ProjectListQueryOrder order = new ProjectListQueryOrder();
        order.setKeyWord(ao.getKeyWord());
        order.setSerialNo(AppUtils.appCode(""));

        ProjectListQueryResult result = projectFacadeClient.projectListQuery(order);
        return new JsonResult(result);
    }

    @PostMapping("/projectCUD")
    public JsonResult projectCUD(@RequestBody ProjectCUDAO ao){
        ProjectCUDOrder order = new ProjectCUDOrder();
        order.setSerialNo(AppUtils.appCode(""));
        BeanCopier.create(ProjectCUDAO.class,ProjectCUDOrder.class,false).copy(ao,order,null);
//        order.setCreateUserId(accountCache.getUserCache().getUserId());
//        order.setCreateUserName(accountCache.getUserCache().getUserName());

        ProjectCUDResult result = projectFacadeClient.projectCUD(order);
        return new JsonResult(result);
    }

    @GetMapping("/projectQuery")
    public JsonResult projectQuery(ProjectQueryAO projectQueryAO){
        ProjectQueryOrder order = new ProjectQueryOrder();
        order.setPageParamInfo(new PageParamInfo(1,10));
        order.setProjectId(projectQueryAO.getProjectId());
        order.setSerialNo(AppUtils.appCode(""));

        ProjectQueryResult result = projectFacadeClient.projectQuery(order);
        return new JsonResult(result);
    }

}
