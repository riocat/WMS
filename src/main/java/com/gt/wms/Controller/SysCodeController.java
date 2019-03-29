package com.gt.wms.Controller;

import com.gt.wms.Entity.SysCode;
import com.gt.wms.Service.SysCodeService;
import com.gt.wms.util.JsonResult;
import com.gt.wms.util.JsonResultStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by rio on 2019/3/25.
 */
@Controller
@RequestMapping("sysCode")
public class SysCodeController {

    Logger logger = LoggerFactory.getLogger(SysCodeController.class);

    @Autowired
    private SysCodeService sysCodeService;

    @RequestMapping("getSysCodeList")
    @ResponseBody
    public JsonResult getSysCodeList(@RequestBody SysCode sysCode) {
        JsonResult result = null;
        result = new JsonResult(JsonResultStatus.success, sysCodeService.getSysCodeList(sysCode), null);
        return result;
    }
}
