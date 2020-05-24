package priv.TzGin.observer.mouseevent.handle;

import priv.TzGin.observer.mouseevent.core.EventObserverable;

//具体的被观察者
public class Mouse extends EventObserverable {

    public void click() {
        System.out.println("调用鼠标单机方法");
        this.trigger(MouseEventType.ON_CLICK);
    }

    public void move() {
        System.out.println("调用鼠标移动方法");
        this.trigger(MouseEventType.ON_MOVE);
    }
}
