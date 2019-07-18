package edu.mum.framework.core;

public interface MyApplicationContext {
    Object getBean(String name);

    Object getBeanByType(Class<?> type);

    MyBeanFactory getBeanFactory();

    void refresh();
}
