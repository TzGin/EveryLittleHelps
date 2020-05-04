package priv.TzGin.factory.factorymethod;

public class PythonCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
