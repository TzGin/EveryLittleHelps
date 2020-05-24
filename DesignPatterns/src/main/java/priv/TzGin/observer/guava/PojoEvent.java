package priv.TzGin.observer.guava;

import com.google.common.eventbus.Subscribe;

public class PojoEvent {

    @Subscribe
    public void observer(Pojo arg) {
        System.out.println("执行PojoEvent方法，传参为：" + arg);
    }
}
