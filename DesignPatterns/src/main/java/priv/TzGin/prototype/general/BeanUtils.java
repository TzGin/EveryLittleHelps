package priv.TzGin.prototype.general;

import java.lang.reflect.Field;

public class BeanUtils {

    public static Object copy(Object prototype){
        Class clazz = prototype.getClass();
        Object returnValue = null;
        try{
            returnValue = clazz.newInstance();
            for (Field field: clazz.getDeclaredFields()) {
                field.setAccessible(true);
                field.set(returnValue, field.get(prototype));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnValue;
    }
}
