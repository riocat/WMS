package com.gt.wms.Controller;

import com.gt.wms.Entity.User;
import com.gt.wms.Service.UserService;
import com.gt.wms.util.*;
import com.gt.wms.vo.NewUrlBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
                                        @RequestParam(defaultValue = "", required = false , name = "userType") String selectType,
                                        @RequestParam(defaultValue = "0", required = false) int pageSize) {
        ModelAndView mav = new ModelAndView("user/userList");
        Map parMap = new HashMap<>();
        if (pageSize == 0) {
            pageSize = setting.pageSize;
        }
        parMap.put("start", (next - 1) * pageSize);
        parMap.put("pageSize", pageSize);
        parMap.put("selectName", selectName);
        parMap.put("selectType", selectType);
        mav.addObject("userList", userService.getPageUserList(parMap));
        mav.addObject("currentPage", next);
        if (StringUtil.isNotEmpty(selectName)) {
            mav.addObject("selectName", selectName);
        } else {
            mav.addObject("selectName", "selectName");
        }
        if (StringUtil.isNotEmpty(selectType)) {
            mav.addObject("selectType", selectType);
        } else {
            mav.addObject("selectType", "selectType");
        }
        mav.addObject("totalPages", userService.getPageNum(parMap));
        return mav;
    }

    @RequestMapping(value = "user/addUser")
    @ResponseBody
    public JsonResult addUser(@RequestBody User puser, HttpSession session) {

        NewUrlBean nub = new NewUrlBean();
        User user = (User) session.getAttribute("user");

        try {
            puser.setCreate_user(user.getId());
            puser.setUpdate_user(user.getId());
            if(userService.uniqueCheck(puser)){
                userService.addUser(puser);
            }else{
                return new JsonResult(JsonResultStatus.fail, null, "用户添加失败", SysErrorCode.NOT_UNIQUE_ENTITY);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("用户添加失败", e);

            return new JsonResult(JsonResultStatus.fail, null, "用户添加失败");
        }

        nub.setNewURL("user/userList");
        return new JsonResult(JsonResultStatus.success, nub, null);
    }

    @RequestMapping(value = "user/deleteUserById")
    public String deleteUserById(@RequestParam String id, HttpSession session) {

        NewUrlBean nub = new NewUrlBean();
        User user = (User) session.getAttribute("user");

        try {
            User puser = new User();
            puser.setId(id);
            puser.setDelete_user(user.getId());
            userService.deleteUserById(puser);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("用户删除失败", e);
        }

        return "redirect:/user/userPageList";
    }

    @RequestMapping(value = "user/toUserUpdate")
    public ModelAndView toUserUpdate(@RequestParam String id) {
        ModelAndView mav = new ModelAndView("user/userUpdate");
        mav.addObject("targetId", id);
        return mav;
    }

    @RequestMapping("user/getUserById")
    @ResponseBody
    public JsonResult getUserById(@RequestParam String id) {
        User user = null;
        try {
            user = userService.getUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("用户添加失败", e);

            return new JsonResult(JsonResultStatus.fail, null, "未找到要修改的用户，请确认");
        }

        if (user != null) {
            return new JsonResult(JsonResultStatus.success, user, null);
        } else {
            return new JsonResult(JsonResultStatus.fail, null, "未找到要修改的用户，请确认");
        }
    }

    @RequestMapping("user/updateUser")
    @ResponseBody
    public JsonResult updateUser(@RequestBody User puser, HttpSession session){
        NewUrlBean nub = new NewUrlBean();
        User user = (User) session.getAttribute("user");

        try {
            puser.setUpdate_user(user.getId());
            if(userService.uniqueCheck(puser)){
                userService.updateUser(puser);
            }else{
                return new JsonResult(JsonResultStatus.fail, null, "用户更新失败", SysErrorCode.NOT_UNIQUE_ENTITY);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("用户更新失败", e);
            return new JsonResult(JsonResultStatus.fail, null, "用户更新失败");
        }

        nub.setNewURL("user/userList");
        return new JsonResult(JsonResultStatus.success, nub, null);
    }
}
