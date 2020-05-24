package priv.TzGin.observer.guava;

import com.google.common.eventbus.EventBus;

public class Test {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();

        PojoEvent pojoEvent = new PojoEvent();
        eventBus.register(pojoEvent);

        VoEvent voEvent = new VoEvent();
        eventBus.register(voEvent);

        eventBus.post(new Pojo("pojo"));
        eventBus.post(new Vo("vo"));
    }
}
