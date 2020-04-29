package priv.TzGin.liskovsubstitution.methodparam.v3;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        Base base = new Child();
        HashMap hashMap1 = new HashMap();
        base.method(hashMap1);

        Child child = new Child();
        HashMap hashMap2 = new HashMap();
        child.method(hashMap2);
    }
}
