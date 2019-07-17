package edu.mum.framework.core;

import java.util.Map;

public interface MyModel {
    void addAttribute(String str, Object obj);
    Map<String, Object> asMap();
}
