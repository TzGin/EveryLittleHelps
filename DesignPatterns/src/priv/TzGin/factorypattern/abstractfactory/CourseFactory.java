package priv.TzGin.factorypattern.abstractfactory;

public abstract class CourseFactory {
    public void init(){
        System.out.println("初始化数据");
    }

    protected abstract INote createNote();

    protected abstract IVideo createVideo();

}
