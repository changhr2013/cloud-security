package com.changhr.cloud.securtiy.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author changhr2013
 * @date 2019/11/24
 */
//@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("[filter] time filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("[filter] time filter start");
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long end = System.currentTimeMillis();
        System.out.println("[filter] time filter=" + (end - start));
        System.out.println("[filter] time filter finish");
    }

    @Override
    public void destroy() {
        System.out.println("[filter] time filter destroy");
    }
}
