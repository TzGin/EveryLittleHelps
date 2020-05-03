package priv.TzGin.factorypattern.factorymethod;

public class JavaCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
