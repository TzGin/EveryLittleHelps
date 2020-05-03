package priv.TzGin.factorypattern.simplefactory.v2.v1;

import priv.TzGin.factorypattern.simplefactory.v2.ICourse;
import priv.TzGin.factorypattern.simplefactory.v2.JavaCourse;
import priv.TzGin.factorypattern.simplefactory.v2.PythonCourse;

/**
 * 将Course抽象成接口ICourse
 * 并将实例化ICourse的任务交给工厂CourseFactory
 */
public class CourseFactory {
    public ICourse create(String name){
        if ("java".equals(name)){
            return new JavaCourse();
        }else if ("Python".equals(name)){
            return new PythonCourse();
        }else {
            return null;
        }
    }
}
