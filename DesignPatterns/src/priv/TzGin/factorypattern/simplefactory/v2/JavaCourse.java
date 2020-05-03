package priv.TzGin.factorypattern.simplefactory.v2;

public class JavaCourse implements ICourse{
    @Override
    public void record() {
        System.out.println("正在录制Java课程");
    }
}
