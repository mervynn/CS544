package edu.mum.framework.core.impl;

import edu.mum.framework.core.MyBeanFactory;

import java.util.HashMap;
import java.util.Map;

public class MyGenericBeanFactory implements MyBeanFactory {

    private final Map<String, Object> beans;

    MyGenericBeanFactory() {
        this.beans = new HashMap<>();
    }

    public void addBean(String name, Object object) {
        this.beans.put(name, object);
    }

    public Object getBean(String name) {
        return this.beans.get(name);
    }

    public Map<String, Object> getBeans() {
        return this.beans;
    }

}
