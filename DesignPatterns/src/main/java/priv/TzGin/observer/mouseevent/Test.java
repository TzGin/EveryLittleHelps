package priv.TzGin.observer.mouseevent;

import priv.TzGin.observer.mouseevent.handle.Mouse;
import priv.TzGin.observer.mouseevent.handle.MouseEventListener;
import priv.TzGin.observer.mouseevent.handle.MouseEventType;

public class Test {
    public static void main(String[] args) {
        //具体观察者
        MouseEventListener listener = new MouseEventListener();
        //具体被观察者
        Mouse mouse = new Mouse();
        mouse.addListener(MouseEventType.ON_CLICK, listener);
        mouse.addListener(MouseEventType.ON_MOVE, listener);

        mouse.click();
        mouse.move();
    }
}
