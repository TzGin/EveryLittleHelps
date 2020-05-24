package priv.TzGin.observer.mouseevent.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

//被观察者抽象
public class EventObserverable {

    protected Map<String, Event> events = new HashMap<String, Event>();

    public void addListener(String eventType, Object target, Method callback) {
        events.put(eventType, new Event(target, callback));
    }

    public void addListener(String eventType, Object target) {
        try {
            addListener(eventType, target, target.getClass().getMethod("on" + toUpperFirstCase(eventType), Event.class));
        } catch (NoSuchMethodException e) {
            return;
        }
    }

    private String toUpperFirstCase(String eventType) {
        char [] chars = eventType.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

    private void trigger(Event event) {
        event.setSource(this);
        event.setTime(System.currentTimeMillis());
        try {
            if (event.getCallback() != null) {
                //用反射调用回调函数
                event.getCallback().invoke(event.getTarget(), event);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void trigger(String trigger) {
        if (!events.containsKey(trigger)) {
            return;
        }
        trigger(events.get(trigger).setTrigger(trigger));
    }

}
