package priv.TzGin.factory.simplefactory.v2.v3;

import priv.TzGin.factory.simplefactory.v2.ICourse;

/**
 * v2类名过长容易出错
 * 修改create形参为Class类型
 */
public class CourseFactory {
    public ICourse create(Class clazz){
        try {
            if (null != clazz){
                return (ICourse) clazz.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
