package priv.TzGin.singleton.lazy;

/**
 * 优点：节省了内存
 * 缺点：不稳定，可能造成线程不安全
 * 运行结果分析：
 *      同一实例：
 *          1、正常顺序执行
 *          2、后者覆盖前者情况
 *      不同实例：
 *          同时进入条件，按顺序返回
 */
public class LazySimpleSingleton {
    private static LazySimpleSingleton instance;

    private LazySimpleSingleton(){}

    public static LazySimpleSingleton getInstance(){
        if (null == instance){
            instance = new LazySimpleSingleton();
        }
        return instance;
    }
}
