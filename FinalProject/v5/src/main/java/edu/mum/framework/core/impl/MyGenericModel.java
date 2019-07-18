package edu.mum.framework.core.impl;

import edu.mum.framework.core.MyModel;

import java.util.HashMap;
import java.util.Map;

public class MyGenericModel extends HashMap<String, Object> implements MyModel {
    @Override
    public void addAttribute(String str, Object obj) {
        this.put(str, obj);
    }

    @Override
    public Map<String, Object> asMap(){
        return this;
    }
}
