package com.gt.wms.Controller;

import com.gt.wms.Entity.User;
import com.gt.wms.Service.UserService;
import com.gt.wms.util.JsonResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.gt.wms.util.JsonResult;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "user/userList")
    public ModelAndView getUserList() {
        ModelAndView mav = new ModelAndView("userList");
        return mav;
    }

    @RequestMapping(value = "user/addUser")
    @ResponseBody
    public ModelAndView getUserList(@RequestBody User puser) {



        ModelAndView mav = new ModelAndView("userList");
        return mav;
    }
}
