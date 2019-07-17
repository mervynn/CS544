package edu.mum.framework.core.impl;

public abstract class MyCommonViewResolver {
    private String prefix;
    private String suffix;

    MyCommonViewResolver(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

}
