package edu.mum.framework.core;

import java.util.Map;

public interface MyBeanFactory {

    void addBean(String name, Object object);

    Object getBean(String name);

    Map<String, Object> getBeans();
}
