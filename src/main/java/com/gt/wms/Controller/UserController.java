package com.gt.wms.Controller;

import com.gt.wms.Entity.User;
import com.gt.wms.Service.UserService;
import com.gt.wms.util.JsonResultStatus;
import com.gt.wms.util.SettingValue;
import com.gt.wms.util.StringUtil;
import com.gt.wms.vo.NewUrlBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.gt.wms.util.JsonResult;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private SettingValue setting;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "user/userPageList")
    public ModelAndView getUserPageList(@RequestParam(defaultValue = "1", required = false) int next,
                                    @RequestParam(defaultValue = "", required = false) String selectName,
                                    @RequestParam(defaultValue = "", required = false) String selectType,
                                    @RequestParam(defaultValue = "0", required = false) int pageSize) {
        ModelAndView mav = new ModelAndView("userList");
        Map parMap = new HashMap<>();
        if(pageSize == 0){
            pageSize = setting.pageSize;
        }
        parMap.put("start", (next - 1) * pageSize);
        parMap.put("pageSize", pageSize);
        parMap.put("selectName", selectName);
        parMap.put("selectType", selectType);
        mav.addObject("userList", userService.getPageUserList(parMap));
        mav.addObject("currentPage", next);
        if(StringUtil.isNotEmpty(selectName)){
            mav.addObject("selectName", selectName);
        }else{
            mav.addObject("selectName", "selectName");
        }
        if(StringUtil.isNotEmpty(selectType)){
            mav.addObject("selectType", selectType);
        }else{
            mav.addObject("selectType", "selectType");
        }
        mav.addObject("totalPages", userService.getPageNum(parMap));
        return mav;
    }

    @RequestMapping(value = "user/addUser")
    @ResponseBody
    public JsonResult getUserList(@RequestBody User puser, HttpSession session, HttpServletResponse response) {

        NewUrlBean nub = new NewUrlBean();
        User user = (User) session.getAttribute("user");

        try {
            puser.setCreate_user(user.getId());
            puser.setUpdate_user(user.getId());
            userService.addUser(puser);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("用户添加失败", e);

            return new JsonResult(JsonResultStatus.fail, null, "用户添加失败");
        }

        nub.setNewURL("user/userList");
        return new JsonResult(JsonResultStatus.success, nub, null);
    }
}
