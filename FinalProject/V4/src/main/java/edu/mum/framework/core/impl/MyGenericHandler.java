package edu.mum.framework.core.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.framework.annotations.MyRequestParam;
import edu.mum.framework.annotations.MyResponseBody;
import edu.mum.framework.core.MyHandler;
import edu.mum.framework.core.MyModel;
import edu.mum.framework.util.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Map;

public class MyGenericHandler implements MyHandler {
    private Method targetMethod;
    private Object targetBean;

    public MyGenericHandler(Method m, Object o) {
        this.targetMethod = m;
        this.targetBean = o;
    }

    @Override
    public MyGenericModelAndView handle(HttpServletRequest req, HttpServletResponse res) throws Exception {

        Class<?>[] parameterTypes = targetMethod.getParameterTypes();
        Parameter[] parameters = targetMethod.getParameters();
        Annotation[][] annotations = targetMethod.getParameterAnnotations();
        Map<String, String[]> parameterMap = req.getParameterMap();
        Object[] paramValues = new Object[parameterTypes.length];
        MyModel model = new MyGenericModel();

        for (int i = 0; i < parameterTypes.length; i++) {
            String paramType = parameterTypes[i].getSimpleName();
            if (paramType.equals("HttpServletRequest")) {
                paramValues[i] = req;
                continue;
            } else if (paramType.equals("HttpServletResponse")) {
                paramValues[i] = res;
                continue;
            } else if (paramType.equals("String")) {
                for (Map.Entry<String, String[]> param : parameterMap.entrySet()) {
                    String value = Arrays.toString(param.getValue()).replaceAll("\\[|\\]", "")
                            .replaceAll(",\\s", ",");

                    // 1. match by @MyRequestParam first
                    boolean isMatchedByAnnName = false;
                    for (Annotation an : annotations[i]) {
                        if (an.annotationType().equals(MyRequestParam.class)
                                && parameters[i].getAnnotation(MyRequestParam.class).value().equals(param.getKey())) {
                            paramValues[i] = value;
                            isMatchedByAnnName = true;
                            break;
                        }
                    }
                    if (isMatchedByAnnName) break;

                    // 2. match by parameter name
                    if (parameters[i].getName().equals(param.getKey())) {
                        paramValues[i] = value;
                    }
                }
            } else if("MyModel".equals(paramType) || "MyGenericModel".equals(paramType)){
                paramValues[i] = model;
            }else{
                throw new Exception(String.format("%s: Parameter type %s is not supported",
                        targetBean.getClass().getName(),
                        paramType));
            }
        }

        if(targetMethod.isAnnotationPresent(MyResponseBody.class)){
            Object obj = targetMethod.invoke(targetBean, paramValues);
            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = Obj.writeValueAsString(obj);
            model.addAttribute(Constants.JSON, jsonStr);
            return new MyGenericModelAndView(null, model);
        }
        // invoke method by reflection
        String retPage = (String) targetMethod.invoke(targetBean, paramValues);
        return new MyGenericModelAndView(retPage, model);

    }
}
