package priv.TzGin.singleton.homework;

public class ExecutorThread implements Runnable{
    @Override
    public void run() {
        Object instance = ContainerSingleton.getInstance("priv.TzGin.singleton.register.TestPojo");
        System.out.println(Thread.currentThread().getName() + ": " + instance);
    }
}
