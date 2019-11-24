package com.changhr.cloud.securtiy.demo.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author changhr2013
 * @date 2019/11/24
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("[interceptor] preHandle");
        httpServletRequest.setAttribute("startTime", System.currentTimeMillis());
        System.out.println("[interceptor] class name " + ((HandlerMethod) o).getBean().getClass().getName());
        System.out.println("[interceptor] method " + ((HandlerMethod) o).getMethod().getName());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("[interceptor] postHandle");
        long startTime = (long) httpServletRequest.getAttribute("startTime");
        long end = System.currentTimeMillis();
        System.out.println("[interceptor] interceptor postHandle time=[" + (end - startTime) + "]");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("[interceptor] afterCompletion");
        long startTime = (long) httpServletRequest.getAttribute("startTime");
        long end = System.currentTimeMillis();
        System.out.println("[interceptor] interceptor afterCompletion time=[" + (end - startTime) + "]");
        System.out.println("[interceptor] exception " + e);
    }
}
