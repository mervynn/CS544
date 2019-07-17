package edu.mum.framework.core.impl;

import edu.mum.framework.core.MyView;
import edu.mum.framework.core.MyViewResolver;

public class MyJSPViewResolver extends MyCommonViewResolver implements MyViewResolver {

    public static final String JSP_VIEW_RESOLVER_BEAN_NAME = "JSPViewResolver";

    public MyJSPViewResolver(String p, String s) {
        super(p, s);
    }

    @Override
    public MyView resolveName(String retName) {
        return new MyJSPView(getPrefix() + retName + getSuffix());
    }
}
