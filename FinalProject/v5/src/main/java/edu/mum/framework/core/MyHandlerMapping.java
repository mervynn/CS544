package edu.mum.framework.core;

import java.util.Map;

public interface MyHandlerMapping {
    Map<String, MyHandler> getHandlerMappings();
}
