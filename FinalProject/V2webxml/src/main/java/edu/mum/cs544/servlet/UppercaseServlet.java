package edu.mum.cs544.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UppercaseServlet extends HttpServlet {

    public UppercaseServlet(){
        System.out.println("construct UppercaseServlet");
    }

    public void init() {
        System.out.println("HttpServlet.init");
    }

    // if implementing a service method, tomcat only calls service
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("HttpServlet.service");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        System.out.println("HttpServlet.doGet");
        String inputString = request.getParameter("input").toUpperCase();
        PrintWriter out = response.getWriter();
        out.println(inputString);
    }

    @Override
    public void destroy() {
        System.out.println("HttpServlet.destroy");
    }
}