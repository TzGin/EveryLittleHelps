package priv.TzGin.factory.abstractfactory;

public class PythonCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("正在录制Python课程");
    }
}
