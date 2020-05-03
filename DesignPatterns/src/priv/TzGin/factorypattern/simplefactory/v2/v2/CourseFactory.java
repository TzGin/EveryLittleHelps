package priv.TzGin.factorypattern.simplefactory.v2.v2;

import priv.TzGin.factorypattern.simplefactory.v2.ICourse;

/**
 * 修改为利用反射创建类
 */
public class CourseFactory {
    public ICourse create(String className){
        try {
            if (!(null == className || "".equals(className))){
                return (ICourse) Class.forName(className).newInstance();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
