package priv.TzGin.factorypattern.abstractfactory;

public class PythonCourseFactory extends CourseFactory{
    @Override
    protected INote createNote() {
        super.init();
        return new PythonNote();
    }

    @Override
    protected IVideo createVideo() {
        super.init();
        return new PythonVideo();
    }
}
