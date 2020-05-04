package priv.TzGin.singleton.homework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 解决容器式单例的线程安全问题
 */
public class ContainerSingleton {

    private static Map<String, Object> ioc = new ConcurrentHashMap<>();

    private ContainerSingleton(){}

    public static Object getInstance(String className){
        Object instance = null;
        if (!ioc.containsKey(className)){
            synchronized (ioc){
                if (!ioc.containsKey(className)){
                    try {
                        instance = Class.forName(className).newInstance();
                        ioc.put(className, instance);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    return instance;
                }else {
                    return ioc.get(className);
                }
            }
        }else {
            return ioc.get(className);
        }
    }
}
