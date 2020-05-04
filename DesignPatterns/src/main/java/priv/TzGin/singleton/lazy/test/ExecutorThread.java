package priv.TzGin.singleton.lazy.test;

import priv.TzGin.singleton.lazy.LazyDoubleCheckSingleton;
import priv.TzGin.singleton.lazy.LazySimpleSingleton;

public class ExecutorThread implements Runnable{
    @Override
    public void run() {
        LazySimpleSingleton instance1 = LazySimpleSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ": " + instance1);

        LazyDoubleCheckSingleton instance2 = LazyDoubleCheckSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ": " + instance2);
    }
}
