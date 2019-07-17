package edu.mum.framework.core;

import edu.mum.framework.annotations.MyController;
import edu.mum.framework.annotations.MyRequestMapping;
import edu.mum.framework.core.impl.MyGenericApplicationContext;
import edu.mum.framework.core.impl.MyGenericHandler;
import edu.mum.framework.core.impl.MyGenericHandlerMapping;
import edu.mum.framework.core.impl.MyGenericModelAndView;
import edu.mum.framework.util.Constants;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

@WebServlet(urlPatterns = "/", loadOnStartup = 0)
public class MyDispatcherServlet extends HttpServlet {

    private MyHandlerMapping myHandlerMapping;
    private MyViewResolver myViewResolver;

    @Override
    public void init() {
        ServletContext sc = getServletContext();
        MyApplicationContext context = (MyApplicationContext)
                sc.getAttribute(MyGenericApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        initStrategies(context);
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            doDispatch(req, res);
        } catch (Exception e) {
            String exp;
            if (e.getMessage() == null || "".equals(e.getMessage())) {
                exp = e.getCause().toString();
            } else {
                exp = e.getMessage();
            }
            res.getWriter().println("500 - Server Exception: \n" + exp);
        }
    }

    private void initStrategies(MyApplicationContext context) {
        initHandlerMapping(context);
        initViewResolver(context);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replace(contextPath, "").replaceAll("/+", "/");
        Map<String, MyHandler> hms = myHandlerMapping.getHandlerMappings();
        if (!hms.containsKey(url)) {
            res.getWriter().write("404 - Not Found");
            return;
        }
        MyHandler myHandler = hms.get(url);
        MyGenericModelAndView mv = myHandler.handle(req, res);
        if(mv.getView() == null){
            res.setHeader("Content-Type", "application/json");
            res.getWriter().write((String) mv.getModel().asMap().get(Constants.JSON));
            return;
        }
        MyView myView = myViewResolver.resolveName((String) mv.getView());

        myView.render(mv.getModel(), req, res);
    }

    private void initHandlerMapping(MyApplicationContext context) {
        this.myHandlerMapping = (MyHandlerMapping) context.getBean(MyGenericHandlerMapping.HANDLER_MAPPING_BEAN_NAME);
        Map<String, MyHandler> hms = myHandlerMapping.getHandlerMappings();
        Map<String, Object> beans = context.getBeanFactory().getBeans();

        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            if (!clazz.isAnnotationPresent(MyController.class)) {
                continue;
            }

            String baseUrl = "";
            if (clazz.isAnnotationPresent(MyRequestMapping.class)) {
                MyRequestMapping annotation = clazz.getAnnotation(MyRequestMapping.class);
                baseUrl = annotation.value();
            }
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (!method.isAnnotationPresent(MyRequestMapping.class)) {
                    continue;
                }
                MyRequestMapping annotation = method.getAnnotation(MyRequestMapping.class);
                String url = annotation.value();
                url = (baseUrl + "/" + url).replaceAll("/+", "/");
                hms.put(url, new MyGenericHandler(method, entry.getValue()));
            }
        }
    }

    private void initViewResolver(MyApplicationContext context) {
        this.myViewResolver = (MyViewResolver) context.getBeanByType(MyViewResolver.class);
    }
}
