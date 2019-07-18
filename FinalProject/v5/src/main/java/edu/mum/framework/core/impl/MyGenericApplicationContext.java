package edu.mum.framework.core.impl;

import edu.mum.framework.annotations.MyAutowired;
import edu.mum.framework.annotations.MyRepository;
import edu.mum.framework.annotations.MyTransactional;
import edu.mum.framework.core.MyApplicationContext;
import edu.mum.framework.core.MyBeanFactory;
import edu.mum.framework.txmock.InTransactionRepositoryHandler;
import edu.mum.framework.txmock.RepositoryHandler;
import edu.mum.framework.txmock.TXCommitHandler;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

public class MyGenericApplicationContext implements MyApplicationContext {

    public static final String ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE = "root_web_application_context_attribute";
    public static final String APPLICATION_PROPERTIES_BEAN_NAME = "application_properties";
    private final MyGenericBeanFactory beanFactory;

    public MyGenericApplicationContext() {
        this.beanFactory = new MyGenericBeanFactory();
    }

    @Override
    public Object getBean(String name) {
        return this.beanFactory.getBean(name);
    }

    @Override
    public Object getBeanByType(Class<?> type) {
        for (Object obj : this.beanFactory.getBeans().values()) {
            if (type.isAssignableFrom(obj.getClass())) {
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
        try {
            for (Object obj : this.beanFactory.getBeans().values()) {
                Class<?> clazz = obj.getClass();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(MyAutowired.class)) {
                        Object bean;
                        if (field.getType().isAnnotationPresent(MyRepository.class)) {
                            if (clazz.isAnnotationPresent(MyTransactional.class)) {
                                InTransactionRepositoryHandler inTransactionRepoHandler =
                                        new InTransactionRepositoryHandler();
                                bean = Proxy.newProxyInstance(
                                        InTransactionRepositoryHandler.class.getClassLoader(),
                                        new Class[]{field.getType()}, inTransactionRepoHandler);
                            } else {
                                RepositoryHandler rh = new RepositoryHandler();
                                bean = Proxy.newProxyInstance(
                                        RepositoryHandler.class.getClassLoader(), new Class[]{field.getType()}, rh);
                            }
                        } else {
                            bean = this.getBeanByType(field.getType());
                            if (bean.getClass().isAnnotationPresent(MyTransactional.class)) {
                                TXCommitHandler txCommitHandler = new TXCommitHandler(bean);
                                bean = Proxy.newProxyInstance(TXCommitHandler.class.getClassLoader(),
                                        new Class[]{field.getType()}, txCommitHandler);
                            }
                        }
                        field.setAccessible(true);
                        field.set(obj, bean);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
