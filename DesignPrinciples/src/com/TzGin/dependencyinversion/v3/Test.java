package com.TzGin.dependencyinversion.v3;

import com.TzGin.dependencyinversion.JavaCourse;

public class Test {
    public static void main(String[] args) {
        Student student = new Student(new JavaCourse());
        student.study();
    }
}
