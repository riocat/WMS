package com.gt.wms.Controller;

import com.gt.wms.util.JsonResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.gt.wms.Entity.User;
import com.gt.wms.Service.UserService;
import com.gt.wms.util.JsonResult;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "login")
	@ResponseBody
	public JsonResult login(@RequestBody User puser, HttpSession session) {
		User user = userService.getUserByName(puser.getName());
		if (user == null) {
			return new JsonResult(JsonResultStatus.fail, null, "用户名不存在");
		} else if (!user.getPassword().equals(puser.getPassword())) {
			return new JsonResult(JsonResultStatus.fail, null, "密码错误");
		}

		session.setAttribute("user",user);

		return new JsonResult(JsonResultStatus.success, null, null);
	}

	@RequestMapping(value = "logined/main")
	public ModelAndView loginTest() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
}
