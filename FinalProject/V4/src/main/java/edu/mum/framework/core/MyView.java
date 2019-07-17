package edu.mum.framework.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MyView {
    void render(MyModel model, HttpServletRequest req, HttpServletResponse res) throws Exception;
}
