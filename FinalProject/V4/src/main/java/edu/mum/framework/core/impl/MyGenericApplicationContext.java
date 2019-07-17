package edu.mum.framework.core.impl;

import edu.mum.framework.annotations.MyAutowired;
import edu.mum.framework.core.MyApplicationContext;
import edu.mum.framework.core.MyBeanFactory;

import java.lang.reflect.Field;

public class MyGenericApplicationContext implements MyApplicationContext {

    public static final String ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE = "root_web_application_context_attribute";
    public static final String APPLICATION_PROPERTIES_BEAN_NAME = "application_properties";
    private final MyGenericBeanFactory beanFactory;

    public MyGenericApplicationContext(){
        this.beanFactory = new MyGenericBeanFactory();
    }

    @Override
    public Object getBean(String name) {
        return this.beanFactory.getBean(name);
    }

    @Override
    public Object getBeanByType(Class<?> type) {
        for(Object obj : this.beanFactory.getBeans().values()){
            if(type.isAssignableFrom(obj.getClass())){
                return obj;
            }
        }
        return null;
    }

    @Override
    public MyBeanFactory getBeanFactory() {
        return this.beanFactory;
    }

    @Override
    public void refresh() {
        for(Object obj : this.beanFactory.getBeans().values()){
            Class<?> clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for(Field field : fields){
                if(field.isAnnotationPresent(MyAutowired.class)){
                    Object bean = this.getBeanByType(field.getType());
                    field.setAccessible(true);
                    try {
                        field.set(obj, bean);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
