package priv.TzGin.factory.simplefactory.v2.v4;

import priv.TzGin.factory.simplefactory.v2.ICourse;
import priv.TzGin.factory.simplefactory.v2.JavaCourse;

public class Test {
    public static void main(String[] args) {
        ICourse course = new CourseFactory().create(JavaCourse.class);
        course.record();
    }
}
