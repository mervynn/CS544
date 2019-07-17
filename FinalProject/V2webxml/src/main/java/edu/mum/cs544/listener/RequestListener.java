package edu.mum.cs544.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestListener implements ServletRequestListener {

    public RequestListener(){
        System.out.println("construct RequestListener");
    }
    public void requestDestroyed(ServletRequestEvent event) {
        System.out.println("ServletRequestListener.requestDestroyed");
        HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
        if (!request.getServletPath().equals("/counter")) {
            ServletContext context = event.getServletContext();
            Object counter = context.getAttribute("counter");
            int cnt = 0;
            if(counter != null) cnt = (Integer) counter;
            context.setAttribute("counter", cnt + 1);
        }
    }

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("ServletRequestListener.requestInitialized");
    }
}
