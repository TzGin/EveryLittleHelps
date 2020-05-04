package priv.TzGin.factory.abstractfactory;

public class JavaCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("正在录制Java课程");
    }
}
