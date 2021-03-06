package com.gt.wms.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gt.wms.Entity.User;
import com.gt.wms.util.StaticFinalValue;
import com.gt.wms.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * Servlet Filter implementation class SessionCheckFilter
 */
public class SessionCheckFilter implements Filter {

    private List<String> loginPaths;

    private boolean isSkip;

    /**
     * Default constructor.
     */
    public SessionCheckFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     * 第一种
     */
    /*
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hsr = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		User user = (User) hsr.getSession().getAttribute("user");
		if (user == null) {
			String url = hsr.getContextPath();
			res.sendRedirect(url);
			return;
		}
		chain.doFilter(request, response);
	}
	*/

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     * 第二种
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (!isSkip) {
            Logger logger = LoggerFactory.getLogger(SessionCheckFilter.class);
//            logger.info("SessionCheckFilter working");

            HttpServletRequest hsr = (HttpServletRequest) request;
            HttpSession session = hsr.getSession(false);
            HttpServletResponse res = (HttpServletResponse) response;

            String servletPath = hsr.getServletPath();
            for (String loginPath : loginPaths) {
                if (servletPath.matches(loginPath)) {
                    chain.doFilter(request, response);
                    return;
                }
            }

            String url = StringUtil.isNotEmpty(hsr.getContextPath()) ? hsr.getContextPath() : "/";
            if (session != null) {
                User user = (User) hsr.getSession().getAttribute("user");
                if (user != null) {
                    chain.doFilter(request, response);
                    return;
                }
            }

            res.sendRedirect(url);
            return;
        }
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        String includePath = fConfig.getInitParameter("allowPathPatterns");
        String[] temp = includePath.split(",");
        this.loginPaths = Arrays.asList(temp);

        this.isSkip = StaticFinalValue.TRUE_STR_L.equals(fConfig.getInitParameter("isSkip")) ? true : false;
    }

}
