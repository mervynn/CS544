package edu.mum.framework.core.impl;

import edu.mum.framework.core.MyHandler;
import edu.mum.framework.core.MyHandlerMapping;

import java.util.HashMap;
import java.util.Map;

public class MyGenericHandlerMapping implements MyHandlerMapping {

    public static final String HANDLER_MAPPING_BEAN_NAME = "handlerMapping";
    private Map<String, MyHandler> handlerMappings;

    public MyGenericHandlerMapping() {
        this.handlerMappings = new HashMap<>();
    }

    @Override
    public Map<String, MyHandler> getHandlerMappings() {
        return handlerMappings;
    }
}
