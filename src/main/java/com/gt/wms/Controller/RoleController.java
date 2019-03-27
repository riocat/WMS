package com.gt.wms.Controller;

import com.gt.wms.Entity.Permission;
import com.gt.wms.Entity.User;
import com.gt.wms.Service.RoleService;
import com.gt.wms.util.JsonResult;
import com.gt.wms.util.JsonResultStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rio on 2019/3/26.
 */
@Controller

public class RoleController {

    Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @RequestMapping("role/getMenuByRole")
    @ResponseBody
    public JsonResult getMenuByRole(HttpSession session) {
        List<Permission> permissions = roleService.getMenuByRole((User) session.getAttribute("user"));
        return new JsonResult(JsonResultStatus.success, permissions, null);
    }
}
