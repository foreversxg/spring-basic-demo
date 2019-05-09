package com.example.demo.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/5/9
 */
public class WebFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String params = request.getParameter("params");
        System.out.println(params);
    }

    @Override
    public void destroy() {

    }
}
