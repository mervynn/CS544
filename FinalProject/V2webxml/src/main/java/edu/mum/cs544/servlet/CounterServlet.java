package edu.mum.cs544.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CounterServlet extends HttpServlet {

    public CounterServlet(){
        System.out.println("construct CounterServlet");
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter pw = resp.getWriter();
        Object count = req.getServletContext().getAttribute("counter");
        pw.println(String.format("Request count: %d", count));
    }
}
