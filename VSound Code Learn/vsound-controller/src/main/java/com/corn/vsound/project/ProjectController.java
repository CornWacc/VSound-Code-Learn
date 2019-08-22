package com.corn.vsound.project;


import com.corn.boot.base.JsonResult;
import com.corn.boot.util.AppUtils;
import com.corn.vsound.project.create.ProjectAddOrder;
import com.corn.vsound.project.create.ProjectAddResult;
import com.corn.vsound.project.list.ProjectListQueryOrder;
import com.corn.vsound.project.list.ProjectListQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/base/project")
public class ProjectController {

    @Autowired
    private ProjectFacade projectFacade;

    @GetMapping("/projectListQuery")
    public JsonResult projectListQuery(String keyWord){
        ProjectListQueryOrder order = new ProjectListQueryOrder();
        order.setKeyWord(keyWord);
        order.setSerialNo("projectListQuery");
        ProjectListQueryResult result = projectFacade.projectListQuery(order);
        return new JsonResult(result);
    }


    @PostMapping("/projectAdd")
    public JsonResult projectAdd(@RequestBody ProjectAddOrder order){
        order.setSerialNo(AppUtils.appCode("projectAdd"));
        ProjectAddResult result = projectFacade.projectAdd(order);
        return new JsonResult(result);
    }
}
