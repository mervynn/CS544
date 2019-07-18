package edu.mum.framework.core;

public interface MyViewResolver {
    String FREEMARKER = "freemarker";
    String JSP = "jsp";
    MyView resolveName(String retName);
}
