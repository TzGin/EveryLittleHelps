package com.TzGin.dependencyinversion.v4;

import com.TzGin.dependencyinversion.JavaCourse;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setICourse(new JavaCourse());
        student.study();
    }
}
