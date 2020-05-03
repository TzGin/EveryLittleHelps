package priv.TzGin.factorypattern.simplefactory.v2;

public class PythonCourse implements ICourse{
    @Override
    public void record() {
        System.out.println("正在录制Python课程");
    }
}
