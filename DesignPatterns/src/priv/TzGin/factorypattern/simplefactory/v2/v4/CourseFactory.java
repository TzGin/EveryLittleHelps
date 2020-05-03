package priv.TzGin.factorypattern.simplefactory.v2.v4;

import priv.TzGin.factorypattern.simplefactory.v2.ICourse;

/**
 * 利用泛型使得传入create的值只能是ICourse的子类，不再需要强转
 * 满足单一职责原则
 * 用户体验上升
 */
public class CourseFactory {
    public ICourse create(Class<? extends ICourse> clazz){
        try {
            if (null != clazz){
                return clazz.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
