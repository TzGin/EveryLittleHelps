package priv.TzGin.observer.guava;

import com.google.common.eventbus.Subscribe;

public class VoEvent {

    @Subscribe
    public void observer(Vo arg) {
        System.out.println("执行VoEvent方法，传参为：" + arg);
    }
}
