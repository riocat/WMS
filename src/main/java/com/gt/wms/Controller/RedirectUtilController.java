package com.gt.wms.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by rio on 2019/3/22.
 */
@Controller
public class RedirectUtilController {

    @RequestMapping(value = "redirectToJSP")
    public ModelAndView redirectToJSP(HttpServletRequest request) {
        String jpsName = request.getParameter("jpsName");
        ModelAndView mav = new ModelAndView();
        mav.setViewName(jpsName);
        return mav;
    }
}
