package com.mftplus.demo.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
@WebFilter(urlPatterns = "/person")
public class PersonFilter implements Filter {
    public PersonFilter() {
        System.out.println("PersonFilter constructor");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("PersonFilter doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        servletRequest.getRequestDispatcher("roleTest.html").forward(servletRequest, servletResponse);
//        ((HttpServletRequest)servletRequest).getSession().getAttribute("user");
    }
}
