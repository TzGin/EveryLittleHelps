package com.TzGin.dependencyinversion.v2;


import com.TzGin.dependencyinversion.JavaCourse;
import com.TzGin.dependencyinversion.PythonCourse;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.study(new JavaCourse());
        student.study(new PythonCourse());
    }
}
