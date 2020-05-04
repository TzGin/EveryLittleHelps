package priv.TzGin.singleton.lazy;

/**
 * 优点：性能高，线程安全
 * 缺点：可读性难度加大，不够优雅
 */
public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton instance;

    private LazyDoubleCheckSingleton(){}

    public static LazyDoubleCheckSingleton getInstance(){
        //检查是否要阻塞
        if (null == instance){
            synchronized (LazyDoubleCheckSingleton.class){
                //检查是否要创建实例
                if (null == instance){
                    instance = new LazyDoubleCheckSingleton();
                    //指令重排序的问题，需要声明变量时加volatile关键字
                }
            }
        }
        return instance;
    }
}
