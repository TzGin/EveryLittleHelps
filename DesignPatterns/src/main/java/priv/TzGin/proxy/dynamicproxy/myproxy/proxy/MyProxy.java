package priv.TzGin.proxy.dynamicproxy.myproxy.proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MyProxy {

    private static final String ln = "\r";

    public static Object newProxyInstance(MyClassLoader loader,
                                          Class<?>[] interfaces,
                                          MyInvocationHandler h) {
        try {
            //1、 动态生成源码.java文件
            String src = generateSrc(interfaces);

            //2、 Java文件输出到磁盘，保存为文件$Proxy0.java
            String filePath = MyProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();

            //3、 把.java编译成$Proxy0.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            //4、 把生成的.class文件加载到JVM中
            Class proxyClass = loader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(MyInvocationHandler.class);
            f.delete();

            //5、 返回新的代理对象
            return c.newInstance(h);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package priv.TzGin.proxy.dynamicproxy.myproxy.proxy;" + ln);
        sb.append("import priv.TzGin.proxy.dynamicproxy.myproxy.client.IPerson;" + ln);
        sb.append("import java.lang.reflect.*;" + ln);
        sb.append("public final class $Proxy0 implements " + interfaces[0].getName() + " {" + ln);
        sb.append("MyInvocationHandler h;" + ln);
        sb.append("public $Proxy0(MyInvocationHandler h) { " + ln);
        sb.append("this.h = h;" + ln);
        sb.append("}" + ln);

        for (Method m : interfaces[0].getMethods()) {
            Class<?>[] params = m.getParameterTypes();

            StringBuffer paramsNames = new StringBuffer();
            StringBuffer paramsValues = new StringBuffer();
            StringBuffer paramsClasses = new StringBuffer();

            for (int i = 0; i < params.length; i++) {
                Class clazz = params[i];
                String type = clazz.getName();
                String paramName = toLowerFirstCase(clazz.getSimpleName()) + i;
                paramsNames.append(type + " " + paramName);
                paramsValues.append(paramName);
                paramsClasses.append(clazz.getName() + ".class");
                if (i < params.length-1 && i > 0) {
                    paramsNames.append(",");
                    paramsClasses.append(",");
                    paramsValues.append(",");
                }
            }

            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(" + paramsNames.toString() + ") {" + ln);
            sb.append("try {" + ln);
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{" + paramsClasses.toString() + "});" + ln);
            sb.append((hasReturnValue(m.getReturnType()) ?  "return " : "") + getCaseCode("this.h.invoke(this, m, new Object[]{" + paramsValues + "});", m.getReturnType()) + ";" + ln);
            sb.append("} catch (RuntimeException | Error var3) {" + ln);
            sb.append("throw var3;" + ln);
            sb.append("} catch (Throwable var4) {" + ln);
            sb.append("throw new UndeclaredThrowableException(var4);" + ln);
            sb.append("}" + ln);
            sb.append(getReturnEmptyCode(m.getReturnType()));
            sb.append("}" + ln);
        }
        sb.append("}" + ln);
        return sb.toString();
    }

    private static final Map<Class, Class> map = new HashMap<Class, Class>();
    static {
        map.put(int.class, Integer.class);
    }

    private static String getReturnEmptyCode(Class<?> returnClass) {
        if (map.containsKey(returnClass)) {
            return "return 0";
        }else if (returnClass == void.class) {
            return "";
        }else {
            return "return null;";
        }
    }

    private static String getCaseCode(String code, Class<?> returnClass) {
        if (map.containsKey(returnClass)) {
            return "((" + map.get(returnClass).getName() + ")" + code + ")." + returnClass.getSimpleName() + "Value()";
        }
        return code;
    }

    private static boolean hasReturnValue(Class<?> clazz) {
        return clazz != void.class;
    }

    private static String toLowerFirstCase(String src) {
        char[] chars = src.toCharArray();
        if (Character.isUpperCase(chars[0])){
            chars[0] += 32;
        }
        return String.valueOf(chars);
    }
}
