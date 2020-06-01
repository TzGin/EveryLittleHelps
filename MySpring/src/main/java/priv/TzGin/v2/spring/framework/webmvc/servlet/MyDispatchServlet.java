package priv.TzGin.v2.spring.framework.webmvc.servlet;

import priv.TzGin.v1.mvcframework.annotation.MyAutowired;
import priv.TzGin.v1.mvcframework.annotation.MyController;
import priv.TzGin.v1.mvcframework.annotation.MyRequestMapping;
import priv.TzGin.v1.mvcframework.annotation.MyService;
import priv.TzGin.v2.spring.framework.context.MyApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 委派模式
 * 职责：负责任务调度，请求分发
 */
public class MyDispatchServlet extends HttpServlet {

    private MyApplicationContext applicationContext;

    //IoC容器，key默认是类名首字母小写，value就是对应的实例对象
    //为了简化程序，暂时不考虑ConcurrentHashMap
    private Map<String, Object> ioc = new HashMap<String, Object>();

    //保存url和Method的对应关系
    //真实Spring源码中，HandlerMapping是一个list而非Map
    private  List<Handler> handlerMapping = new ArrayList<Handler>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //6、委派，根据URL去找到一个对应的Method调用
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("500 Exception, Detail : " + Arrays.toString(e.getStackTrace()));
        }
    }

    /**
     * 匹配URL
     * @param req
     * @param resp
     * @throws Exception
     */
    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        try {
            Handler handler = getHandler(req);
            if (null == handler) {
                resp.getWriter().write("404 Not Found!!!");
                return;
            }

            //获取方法的形参列表
            Class<?>[] parameterTypes = handler.method.getParameterTypes();
            //保存所有需要自动赋值的参数值
            Object[] parameterValues = new Object[parameterTypes.length];

            Map<String, String[]> parameters = req.getParameterMap();
            for (Map.Entry<String, String[]> parameter : parameters.entrySet()) {
                String value = Arrays.toString(parameter.getValue()).replaceAll("\\[|\\]", "").replaceAll(",\\s", ",");

                //如果找到匹配的对象，就开始填充参数值
                if (!handler.parameterIndexMapping.containsKey(parameter.getKey())) {
                    continue;
                }

                int index = handler.parameterIndexMapping.get(parameter.getKey());
                parameterValues[index] = convert(parameterTypes[index], value);
            }

            //设置方法中的request和response对象
            int reqIndex = handler.parameterIndexMapping.get(HttpServletRequest.class.getName());
            parameterValues[reqIndex] = req;
            int respIndex = handler.parameterIndexMapping.get(HttpServletResponse.class.getName());
            parameterValues[respIndex] = resp;

            handler.method.invoke(handler.controller, parameterValues);
        }catch (Exception e) {
            throw e;
        }
    }

    /**
     * 匹配URL
     * @param req
     * @return
     * @throws Exception
     */
    private Handler getHandler(HttpServletRequest req) throws Exception {
        if (handlerMapping.isEmpty()) {
            return null;
        }

        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replace(contextPath, "").replaceAll("/+", "/");

        for (Handler handler : handlerMapping) {
            try {
                Matcher matcher = handler.pattern.matcher(url);
                //如果没有匹配上继续下一个匹配
                if (!matcher.matches()) {
                    continue;
                }
                return handler;
            } catch (Exception e) {
                throw e;
            }
        }
        return null;
    }

    /**
     * URL传过来的参数都是String类型的，HTTP是基于字符串协议
     * 只需要把String转换为任意类型即可
     * 这里可以使用策略模式优化代码
     * @param type
     * @param value
     * @return
     */
    private Object convert(Class<?> type, String value) {
        if (Integer.class == type) {
            return Integer.valueOf(value);
        }

        if (Double.class == type) {
            return Double.valueOf(value);
        }
        return value;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        //初始化Spring核心IoC容器
        applicationContext = new MyApplicationContext(config.getInitParameter("contextConfigLocation"));

        //=========MVC部分=========
        //5、初始化HandlerMapping
        doInitHandlerMapping();

        System.out.println("My Spring framework is init");
    }

    //策略模式的应用案例
    //初始化url和Method的一对一对应关系
    private void doInitHandlerMapping() {
        if (ioc.isEmpty()) {
            return;
        }

        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            if (!clazz.isAnnotationPresent(MyController.class)) {
                continue;
            }

            //提取类上面配置的URL @MyRequestMapping("/demo")
            String baseUrl = "";
            if (clazz.isAnnotationPresent(MyRequestMapping.class)) {
                MyRequestMapping requestMapping = clazz.getAnnotation(MyRequestMapping.class);
                baseUrl = requestMapping.value();
            }

            //只获取public方法
            for (Method method : clazz.getMethods()) {
                if (!method.isAnnotationPresent(MyRequestMapping.class)) {
                    return;
                }

                //提取每个方法上面配置的URL
                MyRequestMapping requestMapping = method.getAnnotation(MyRequestMapping.class);

                String url = ("/" + baseUrl + "/" + requestMapping.value()).replaceAll("/+", "/");
                Pattern pattern = Pattern.compile(url);
                handlerMapping.add(new Handler(entry.getValue(), method, pattern));
                System.out.println("Mapped : " + url + "," + method);
            }
        }
    }


}
