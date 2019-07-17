package edu.mum.framework.core;

import edu.mum.framework.core.impl.MyGenericModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MyHandler {
    MyGenericModelAndView handle(HttpServletRequest req, HttpServletResponse res) throws Exception;
}
