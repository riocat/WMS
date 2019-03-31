package com.gt.wms.Controller;

import com.gt.wms.Entity.Permission;
import com.gt.wms.Service.PermissionService;
import com.gt.wms.util.JsonResult;
import com.gt.wms.util.JsonResultStatus;
import com.gt.wms.util.SettingValue;
import com.gt.wms.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rio on 2019/3/28.
 */
@Controller
@RequestMapping("permission")
public class PermissionController {


    Logger logger = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    private SettingValue setting;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "toPermissionMain")
    public ModelAndView toPermissionMain() {
        ModelAndView mav = new ModelAndView("permission/toPermissionMain");
        return mav;
    }

    @RequestMapping(value = "getZtreeData")
    @ResponseBody
    public JsonResult getZtreeDataPermission() {
        List<Permission> list = permissionService.getSimplePermissionList();
        return new JsonResult(JsonResultStatus.success, list, null);
    }
}
