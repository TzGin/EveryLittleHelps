package priv.TzGin.delegate.general;

import java.util.Random;

public class Delegate implements Task {
    @Override
    public void doTask() {
        System.out.println("代理执行开始");

        Task task = null;
        if (new Random().nextBoolean()) {
            task = new ConcreteA();
            task.doTask();
        }else {
            task = new ConcreteB();
            task.doTask();
        }
        System.out.println("代理执行结束");
    }
}
