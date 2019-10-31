package com.jason.integrationweb.servlet;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class MyFilter  implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter");
        chain.doFilter(request,response);
    }
}
