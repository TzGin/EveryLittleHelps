package priv.TzGin.v1.mvcframework.v2;

import priv.TzGin.v1.mvcframework.annotation.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyDispatchServlet extends HttpServlet {

    //保存application.properties配置文件中的内容
    private Properties contextConfig = new Properties();

    //保存扫描的所有的类名
    //享元模式，缓存
    private List<String> classNames = new ArrayList<String>();

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

        //1、加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));

        //2、扫描相关的类
        doScanner(contextConfig.getProperty("scanPackage"));

        //=========IoC部分=========
        //3、初始化IoC容器，将扫描到的相关的类实例化，保存到IoC容器中
        doInstance();

        //=========AOP部分=========
        //AOP，生成新的代理类

        //=========DI部分=========
        //4、完成自动化的依赖注入
        doAutowired();

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

    private void doAutowired() {
        if (ioc.isEmpty()) {
            return;
        }

        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            //拿到实例的所有的字段
            //Declared 所有的，包括private/protected/default/public 修饰的字段都取出来
            //正常来说，只能拿到public修饰的
            Field [] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAnnotationPresent(MyAutowired.class)) {
                    return;
                }

                MyAutowired autowired = field.getAnnotation(MyAutowired.class);
                //如果用户没有自定义beanName，默认就根据类型注入
                String beanName = autowired.value().trim();
                if ("".equals(beanName)) {
                    beanName = field.getType().getName();
                }

                //如果是public以外的修饰符，只要加了@Autowired注解，都要强制赋值
                //暴力访问
                field.setAccessible(true);

                try {
                    //ioc.get(beanName) 相当于通过接口的全名拿到接口的实现的实例
                    field.set(entry.getValue(), ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    continue;
                }
            }
        }
    }

    //工厂模式的具体实现
    private void doInstance() {
        if (classNames.isEmpty()) {
            return;
        }

        try {
            for (String className : classNames) {
                Class<?> clazz = Class.forName(className);

                //加了注解的类需要初始化
                if (clazz.isAnnotationPresent(MyController.class)) {
                    //class类名首字母小写
                    String beanName = toLowerFirstCase(clazz.getSimpleName());
                    Object instance = clazz.newInstance();
                    ioc.put(beanName, instance);
                } else if (clazz.isAnnotationPresent(MyService.class)) {
                    //1、默认就根据beanName类名首字母小写
                    String beanName = toLowerFirstCase(clazz.getSimpleName());

                    //2、使用自定义的beanName
                    MyService service = clazz.getAnnotation(MyService.class);
                    if (!"".equals(service.value())) {
                        beanName = service.value();
                    }

                    Object instance = clazz.newInstance();
                    ioc.put(beanName, instance);

                    //3、如果是接口
                    //判断有多少个实现类，如果只有一个，默认就选择这个实现类
                    // 如果有多个，只能抛异常
                    for (Class<?> i : clazz.getInterfaces()) {
                        if (ioc.containsKey(i.getName())) {
                            throw new Exception("The " + i.getName() + " is exists!!");
                        }
                        ioc.put(i.getName(), instance);
                    }

                } else {
                    continue;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String toLowerFirstCase(String simpleName) {
        char [] chars = simpleName.toCharArray();
        //大小写字母的ASCII码相差32
        //大写字母的ASCII码要小于小写字母的ASCII码
        //在java中，对char做算术运算实际上就是对ASCII码做算术运算
        chars[0] += 32;
        return String.valueOf(chars);
    }

    //扫描出相关的类
    private void doScanner(String scanPackage) {
        //jar、war、zip、rar
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));

        //scanPackage = priv.TzGin.v1.demo 存储的是包路径
        //转换为文件路径，把.替换为/
        //classpath下不仅有.class文件，还有.xml文件，.properties文件
        File classPath = new File(url.getFile());
        //当成是一个ClassPath文件夹
        for (File file : classPath.listFiles()) {
            if (file.isDirectory()) {
                //如果是文件夹调用自身迭代
                doScanner(scanPackage + "." + file.getName());
            } else {
                //变成包名.类名
                //为Class.forName(className);做准备
                if (!file.getName().endsWith(".class")) {
                    continue;
                }
                String className = scanPackage + "." + file.getName().replace(".class", "");
                classNames.add(className);
            }
        }

    }

    //加载配置文件
    private void doLoadConfig(String contextConfigLocation) {
        //直接从类路径下找到Spring主配置文件所在的路径
        //并且将其读取出来放到Properties对象中
        //相对于scanPackage=priv.TzGin.demo从文件中保存到了内存中
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            contextConfig.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
