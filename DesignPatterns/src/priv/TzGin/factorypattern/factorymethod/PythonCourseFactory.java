package priv.TzGin.factorypattern.factorymethod;

public class PythonCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
