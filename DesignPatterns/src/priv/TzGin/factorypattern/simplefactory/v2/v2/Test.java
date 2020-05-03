package priv.TzGin.factorypattern.simplefactory.v2.v2;

import priv.TzGin.factorypattern.simplefactory.v2.ICourse;

public class Test {
    public static void main(String[] args) {
        ICourse course = new CourseFactory().create("priv.TzGin.factory.simplefactory.v2.JavaCourse");
        course.record();
    }
}
