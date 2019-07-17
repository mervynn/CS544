package edu.mum.framework.core.impl;

import edu.mum.framework.core.MyModel;
import edu.mum.framework.core.MyModelAndView;

public class MyGenericModelAndView implements MyModelAndView {
    private Object view;
    private MyModel model;

    MyGenericModelAndView(Object v, MyModel m){
        this.view = v;
        this.model = m;
    }

    @Override
    public Object getView() {
        return this.view;
    }

    @Override
    public MyModel getModel(){
        return this.model;
    }
}
