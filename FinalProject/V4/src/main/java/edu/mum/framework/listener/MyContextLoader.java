package edu.mum.framework.listener;

import edu.mum.framework.annotations.MyComponent;
import edu.mum.framework.annotations.MyController;
import edu.mum.framework.annotations.MyRepository;
import edu.mum.framework.annotations.MyService;
import edu.mum.framework.core.MyApplicationContext;
import edu.mum.framework.core.MyBeanFactory;
import edu.mum.framework.core.MyHandlerMapping;
import edu.mum.framework.core.MyViewResolver;
import edu.mum.framework.core.impl.MyFreemarkerViewResolver;
import edu.mum.framework.core.impl.MyGenericApplicationContext;
import edu.mum.framework.core.impl.MyGenericHandlerMapping;
import edu.mum.framework.core.impl.MyJSPViewResolver;
import edu.mum.framework.util.MyUtils;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class MyContextLoader {

    private static final String CONTEXT_CONFIG_LOCATION = "application.properties";

    void initApplicationContext(ServletContext servletContext) {
        this.configureAndRefreshApplicationContext(servletContext);
    }

    private void configureAndRefreshApplicationContext(ServletContext servletContext) {
        MyApplicationContext myContext = new MyGenericApplicationContext();
        servletContext.setAttribute(MyGenericApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, myContext);
        initProperties(myContext);
        initBeans(myContext);
        myContext.refresh();
    }

    private void initProperties(MyApplicationContext context) {
        try (InputStream resourceAsStream = this.getClass().getClassLoader()
                .getResourceAsStream(CONTEXT_CONFIG_LOCATION)) {
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            MyBeanFactory bf = context.getBeanFactory();
            bf.addBean(MyGenericApplicationContext.APPLICATION_PROPERTIES_BEAN_NAME, properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initBeans(MyApplicationContext context) {
        MyBeanFactory bf = context.getBeanFactory();
        Properties properties = (Properties) bf.getBean(MyGenericApplicationContext.APPLICATION_PROPERTIES_BEAN_NAME);
        String scanPackage = properties.getProperty("scanPackage");
        List<String> classNames = MyUtils.scanClasses(scanPackage);
        for (String className : classNames) {
            try {
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(MyController.class)
                        || clazz.isAnnotationPresent(MyComponent.class)
                        || clazz.isAnnotationPresent(MyService.class)
                        || clazz.isAnnotationPresent(MyRepository.class)) {
                    bf.addBean(MyUtils.toLowerFirstWord(clazz.getSimpleName()), clazz.newInstance());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String viewResolverName = properties.getProperty("viewResolver.name");
        String viewResolverPrefix = properties.getProperty("viewResolver.prefix");
        String viewResolverSuffix = properties.getProperty("viewResolver.suffix");
        if (MyViewResolver.FREEMARKER.equals(viewResolverName))
            bf.addBean(MyFreemarkerViewResolver.FREEMARKER_VIEW_RESOLVER_BEAN_NAME,
                    new MyFreemarkerViewResolver(viewResolverPrefix, viewResolverSuffix));
        if (MyViewResolver.JSP.equals(viewResolverName))
            bf.addBean(MyJSPViewResolver.JSP_VIEW_RESOLVER_BEAN_NAME,
                    new MyJSPViewResolver(viewResolverPrefix, viewResolverSuffix));
        bf.addBean(MyGenericHandlerMapping.HANDLER_MAPPING_BEAN_NAME, new MyGenericHandlerMapping());
    }
}
