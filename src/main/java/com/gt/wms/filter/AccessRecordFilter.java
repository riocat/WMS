package com.gt.wms.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rio on 2018/9/28.
 */
public class AccessRecordFilter implements Filter {

    private MongoOperations anotherMongoTemplate;

    private static final String COLLECTION_NAME = "requestLog";

    private ObjectMapper om = new ObjectMapper();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if (this.anotherMongoTemplate == null) {
            WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
            this.anotherMongoTemplate = (MongoOperations) ctx.getBean("anotherMongoTemplate");
            if(!this.anotherMongoTemplate.collectionExists(COLLECTION_NAME))
                this.anotherMongoTemplate.createCollection(COLLECTION_NAME);
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest hsr = (HttpServletRequest) request;

        Map<String,Object> reqInfo = new HashMap<String,Object>();

        reqInfo.put("remoteAddr",hsr.getRemoteAddr());
        reqInfo.put("method",hsr.getMethod());
        reqInfo.put("requestURI",hsr.getRequestURI());
        reqInfo.put("requestTime", LocalDateTime.now());

        StringBuffer requestParamter = new StringBuffer();
        Enumeration<String> paramNames =  hsr.getParameterNames();
        while (paramNames.hasMoreElements()){
            String paramName = paramNames.nextElement();

            requestParamter.append(paramName+"=");
            for(String value:hsr.getParameterValues(paramName)){
                requestParamter.append(value+",");
            }
            requestParamter.deleteCharAt(requestParamter.length()-1);
            requestParamter.append("&");
        }

        reqInfo.put("requestInfo",requestParamter.toString());

        anotherMongoTemplate.insert(reqInfo,COLLECTION_NAME);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
