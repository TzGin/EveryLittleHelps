package priv.TzGin.observer.mouseevent.handle;

import priv.TzGin.observer.mouseevent.core.Event;

//观察者
public class MouseEventListener {

    public void onClick(Event e) {
        System.out.println("触发鼠标单机事件:" + e);
    }

    public void onMove(Event e) {
        System.out.println("触发鼠标移动事件:" + e);
    }
}
