package priv.TzGin.factory.abstractfactory;

public abstract class CourseFactory {
    public void init(){
        System.out.println("初始化数据");
    }

    protected abstract INote createNote();

    protected abstract IVideo createVideo();

}
