package priv.TzGin.singleton.register;

import java.lang.reflect.Constructor;

public class EnumSingletonTest {
    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.getInstance();
        instance.setData(new Object());

        try {
            Class clazz = EnumSingleton.class;
            Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true);
            Object o = constructor.newInstance();
            System.out.println(o);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
