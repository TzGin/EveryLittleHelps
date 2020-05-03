package priv.TzGin.factorypattern.simplefactory.v2.v1;

import priv.TzGin.factorypattern.simplefactory.v2.ICourse;

public class Test {
    public static void main(String[] args) {
        ICourse course = new CourseFactory().create("java");
        course.record();
    }
}
