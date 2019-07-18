package edu.mum.framework.core.impl;

import edu.mum.framework.core.MyModel;
import edu.mum.framework.core.MyView;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.StringWriter;
import java.util.Map;

public class MyFreeMarkerView extends MyCommonView implements MyView {

    MyFreeMarkerView(String uri) {
        setUri(uri);
    }

    @Override
    public void render(MyModel model, HttpServletRequest req, HttpServletResponse res) throws Exception {
        Configuration config = new Configuration();
        config.setServletContextForTemplateLoading(req.getServletContext(), "");
        config.setObjectWrapper(new DefaultObjectWrapper());
        Map<String, Object> root = model.asMap();
        root.put("contextPath", req.getContextPath());
        Template template = config.getTemplate(getUri());
        StringWriter out = new StringWriter();
        template.process(root, out);
        res.getWriter().write(out.getBuffer().toString());
    }
}
