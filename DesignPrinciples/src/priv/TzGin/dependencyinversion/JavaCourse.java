package priv.TzGin.dependencyinversion;

public class JavaCourse implements ICourse {
    @Override
    public void study() {
        System.out.println("Student正在学习Java课程");
    }
}
