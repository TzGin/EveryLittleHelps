package priv.TzGin.v2.spring.framework.webmvc.servlet;

import priv.TzGin.v1.mvcframework.annotation.MyRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Handler {

    protected Object controller;    //保存方法对应的实例
    protected Method method;        //保存映射的方法
    protected Pattern pattern;      //${} url占位符解析
    protected Map<String, Integer> parameterIndexMapping;   //参数顺序

    public Handler(Object controller, Method method, Pattern pattern) {
        this.controller = controller;
        this.method = method;
        this.pattern = pattern;

        parameterIndexMapping = new HashMap<String, Integer>();
        putParameterIndexMapping(method);
    }

    private void putParameterIndexMapping(Method method) {
        //提取方法中加了注解的参数
        Annotation [] [] pa = method.getParameterAnnotations();
        for (int i = 0; i < pa.length; i++) {
            for (Annotation a : pa[i]) {
                if (a instanceof MyRequestParam) {
                    String parameterName = ((MyRequestParam) a).value();
                    if (!"".equals(parameterName.trim())) {
                        parameterIndexMapping.put(parameterName, i);
                    }
                }
            }
        }

        //提取方法中的request和response参数
        Class<?> [] parametersTypes = method.getParameterTypes();
        for (int i = 0; i < parametersTypes.length; i++) {
            Class<?> type = parametersTypes[i];
            if (type == HttpServletRequest.class || type == HttpServletResponse.class) {
                parameterIndexMapping.put(type.getName(), i);
            }
        }
    }
}
