package edu.mum.framework.core.impl;

import edu.mum.framework.core.MyModel;
import edu.mum.framework.core.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MyJSPView extends MyCommonView implements MyView {

    MyJSPView(String uri) {
        setUri(uri);
    }

    @Override
    public void render(MyModel model, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        for (Map.Entry<String, Object> e : model.asMap().entrySet())
            req.setAttribute(e.getKey(), e.getValue());
        req.getRequestDispatcher(getUri()).forward(req, res);
    }
}
