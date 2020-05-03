package priv.TzGin.singletonpattern;

/**
 * 优点：执行效率高，性能高，没有任何的锁
 * 缺点：系统很大时，类加载就实例化了单例，如创建后不使用，可能会造成内存浪费
 */
public class HungrySingleton {
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
