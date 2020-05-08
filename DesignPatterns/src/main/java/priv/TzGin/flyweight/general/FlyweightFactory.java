package priv.TzGin.flyweight.general;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private static Map<String, IFlyweight> pool = new HashMap<String, IFlyweight>();

    public static IFlyweight getFlyweight(String intrinsicState) {
        if (!pool.containsKey(intrinsicState)) {
            IFlyweight flyweight = new ConcreteFlyweight(intrinsicState);
            pool.put(intrinsicState, flyweight);
        }
        return pool.get(intrinsicState);
    }
}
