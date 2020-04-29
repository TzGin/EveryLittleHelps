package priv.TzGin.dependencyinversion.v3;

import priv.TzGin.dependencyinversion.JavaCourse;

public class Test {
    public static void main(String[] args) {
        Student student = new Student(new JavaCourse());
        student.study();
    }
}
