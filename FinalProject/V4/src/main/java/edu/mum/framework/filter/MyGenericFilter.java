package edu.mum.framework.filter;

import edu.mum.framework.core.MyApplicationContext;
import edu.mum.framework.core.impl.MyGenericApplicationContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Properties;

@WebFilter(urlPatterns = "/*")
public class MyGenericFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        String ip = request.getRemoteAddr();
        if (ip.equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
            InetAddress inetAddress = InetAddress.getLocalHost();
            String ipAddress = inetAddress.getHostAddress();
            ip = ipAddress;
        }
        MyApplicationContext context = (MyApplicationContext) request.getServletContext()
                .getAttribute(MyGenericApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        Properties properties = (Properties) context.getBean(MyGenericApplicationContext.APPLICATION_PROPERTIES_BEAN_NAME);
        String blacklist = properties.getProperty("blacklist");

        if(blacklist != null && !"".equals(blacklist)){
            if(Arrays.asList(blacklist.split(",")).contains(ip)){
                response.getWriter().println("403.6 - IP address rejected");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
