package priv.TzGin.liskovsubstitution.methodparam.v1;

import java.util.HashMap;
import java.util.Map;

public class ChildTest {
    public static void main(String[] args) {
        Base base = new Child();
        HashMap hashMap1 = new HashMap();
        base.method(hashMap1);

        Child child = new Child();
        HashMap hashMap = new HashMap();
        child.method(hashMap);

        Map map = new HashMap();
        child.method(map);
    }
}
