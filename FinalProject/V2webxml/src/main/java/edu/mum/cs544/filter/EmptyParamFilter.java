package edu.mum.cs544.filter;

import javax.servlet.*;
import java.io.IOException;

public class EmptyParamFilter implements Filter {

    public EmptyParamFilter(){
        System.out.println("construct EmptyParamFilter");
    }
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter.init");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter.doFilter");
        String inputString = servletRequest.getParameter("input");
        if (inputString != null && inputString.matches("[A-Za-z0-9]+")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletResponse.getWriter().println("Missing input parameter");
        }
    }
    // implementations for other methods
    public void destroy() {
        System.out.println("Filter.destroy");
    }
}