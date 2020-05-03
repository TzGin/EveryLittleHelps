package priv.TzGin.factorypattern.abstractfactory;

public class JavaCourseFactory extends CourseFactory{
    @Override
    protected INote createNote() {
        super.init();
        return new JavaNote();
    }

    @Override
    protected IVideo createVideo() {
        super.init();
        return new JavaVideo();
    }
}
