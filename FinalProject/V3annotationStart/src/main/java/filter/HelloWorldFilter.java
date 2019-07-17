package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class HelloWorldFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("HelloWorldFilter.init");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("HelloWorldFilter.doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
        System.out.println("HelloWorldFilter.destroy");
    }
}
