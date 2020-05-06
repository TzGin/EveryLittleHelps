package priv.TzGin.proxy.dynamicproxy.myproxy.client;

import priv.TzGin.proxy.dynamicproxy.myproxy.proxy.MyClassLoader;
import priv.TzGin.proxy.dynamicproxy.myproxy.proxy.MyInvocationHandler;
import priv.TzGin.proxy.dynamicproxy.myproxy.proxy.MyProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ConcreteProxy implements MyInvocationHandler {
    private IPerson target;

    public IPerson getInstance(IPerson target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return (IPerson) MyProxy.newProxyInstance(new MyClassLoader(), clazz.getInterfaces(), this);
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
