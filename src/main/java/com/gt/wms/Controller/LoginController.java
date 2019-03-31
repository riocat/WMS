package com.gt.wms.Controller;

import com.gt.wms.Entity.Permission;
import com.gt.wms.Service.RoleService;
import com.gt.wms.util.JsonResultStatus;
import com.gt.wms.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "login")
    @ResponseBody
    public JsonResult login(@RequestBody User puser, HttpSession session) {
        User user = userService.getUserByLoginid(puser.getName());
        if (user == null) {
            return new JsonResult(JsonResultStatus.fail, null, "用户名不存在");
        } else if (!user.getPassword().equals(puser.getPassword())) {
            return new JsonResult(JsonResultStatus.fail, null, "密码错误");
        }

        session.setAttribute("user", user);

        return new JsonResult(JsonResultStatus.success, null, null);
    }

    @RequestMapping(value = "logined/main")
    public ModelAndView toMain(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("main");
        List<Permission> list = roleService.getMenuByRole((User) session.getAttribute("user"));
        mav.addObject("menuHtml", createMenu(list, new StringBuffer()));
        return mav;
    }

    private String createMenu(List<Permission> list, StringBuffer stringBuffer) {
        for (Permission p : list) {
            stringBuffer.append("<li class='nav-item nav-dropdown open'>");
            stringBuffer.append("<a href='javascript:void(0)' class='nav-link nav-dropdown-toggle'>");
            stringBuffer.append("<i class='icon icon-target'></i> " + p.getName() + " <i class='fa fa-caret-left'></i>");
            stringBuffer.append("</a>");
            List<Permission> subPermissions = p.getSubPermissions();
            if (subPermissions.size() > 0) {
                stringBuffer.append("<ul class='nav-dropdown-items'>");
                for (Permission sp : subPermissions) {
                    stringBuffer.append("<li class='nav-item subitem'>");
                    if (StringUtil.isNotEmpty(sp.getUrl())) {
                        stringBuffer.append("<a onclick='changeIframe(this,\"" + sp.getUrl() + "\")' name='"+sp.getUrl()+"' class='nav-link' style='color:#f8f9fa;'>");

                    } else {
                        stringBuffer.append("<a onclick='changeIframe(this,\"\")' class='nav-link' style='color:#f8f9fa;'>");

                    }
                    stringBuffer.append("<i class='icon .icon-pencil'></i> " + sp.getName());
                    stringBuffer.append("</a>");
                    stringBuffer.append("</li>");
                }
                stringBuffer.append("</ul>");
            }
            stringBuffer.append("</li>");
        }

        return stringBuffer.toString();
    }

    @RequestMapping(value = "logined/loginOut")
    public String loginOut(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }
}
