package com.nhnacademy.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "counterFilter", urlPatterns = "/*")
public class CounterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        ServletContext servletContext = request.getServletContext();
        int counter = (int) servletContext.getAttribute("counter");
        servletContext.setAttribute("counter", ++counter);

        chain.doFilter(request, response);
    }

}
