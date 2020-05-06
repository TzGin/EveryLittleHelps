package priv.TzGin.proxy.dynamicproxy.jdkproxy;

import priv.TzGin.proxy.IPerson;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK提供的Proxy必须要求有一个接口
 */
public class JdkProxy implements InvocationHandler {

    private IPerson target;

    public IPerson getInstance(IPerson target) {
        this.target = target;
        Class<?> clazz = target.getClass();

        return (IPerson) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    public void before() {
        System.out.println("我是媒婆，已经收集你的要求，开始物色");
    }

    public void after() {
        System.out.println("双方同意，开始交往");
    }
}
