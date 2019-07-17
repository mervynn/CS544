package edu.mum.framework.core.impl;

import edu.mum.framework.core.MyView;
import edu.mum.framework.core.MyViewResolver;

public class MyFreemarkerViewResolver extends MyCommonViewResolver implements MyViewResolver {
    public static final String FREEMARKER_VIEW_RESOLVER_BEAN_NAME = "freemarkerViewResolver";

    public MyFreemarkerViewResolver(String p, String s) {
        super(p, s);
    }

    @Override
    public MyView resolveName(String retName){
        return new MyFreeMarkerView(getPrefix() + retName + getSuffix());
    }
}
