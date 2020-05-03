package priv.TzGin.factorypattern.factorymethod;

public class Test {
    public static void main(String[] args) {
        ICourseFactory factory = new JavaCourseFactory();
        ICourse course = factory.create();
        course.record();
    }
}
