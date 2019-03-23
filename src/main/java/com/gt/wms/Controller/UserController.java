package com.gt.wms.Controller;

import com.gt.wms.Entity.User;
import com.gt.wms.Service.UserService;
import com.gt.wms.util.JsonResultStatus;
import com.gt.wms.vo.NewUrlBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.gt.wms.util.JsonResult;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "user/userList")
    public ModelAndView getUserList() {
        ModelAndView mav = new ModelAndView("userList");
        return mav;
    }

    @RequestMapping(value = "user/addUser")
    @ResponseBody
    public JsonResult getUserList(@RequestBody User puser, HttpServletResponse response) {

        NewUrlBean nub = new NewUrlBean();

        try {
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
