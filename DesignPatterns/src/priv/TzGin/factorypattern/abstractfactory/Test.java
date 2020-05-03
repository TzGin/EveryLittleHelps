package priv.TzGin.factorypattern.abstractfactory;

public class Test {
    public static void main(String[] args) {
        CourseFactory factory = new JavaCourseFactory();
        factory.createNote().edit();
        factory.createVideo().record();
    }
}
