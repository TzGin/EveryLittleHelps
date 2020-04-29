package priv.TzGin.dependencyinversion.v2;


import priv.TzGin.dependencyinversion.JavaCourse;
import priv.TzGin.dependencyinversion.PythonCourse;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.study(new JavaCourse());
        student.study(new PythonCourse());
    }
}
