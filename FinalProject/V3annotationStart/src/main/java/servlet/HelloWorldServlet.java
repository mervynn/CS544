package servlet;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class HelloWorldServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("HelloWorldServlet.init");
    }


    @Override
    public void service(ServletRequest req, ServletResponse res) throws IOException {
        System.out.println("HelloWorldServlet.service");
        PrintWriter pw = res.getWriter();
        pw.println("HelloWorldServlet.service");
    }
}
