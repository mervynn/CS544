package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class HelloWorldListener implements ServletRequestListener {

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("HelloWorldListener.requestInitialized");
    }

    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("HelloWorldListener.requestDestroyed");
    }
}
