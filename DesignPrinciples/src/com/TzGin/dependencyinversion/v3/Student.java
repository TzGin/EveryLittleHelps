package com.TzGin.dependencyinversion.v3;

import com.TzGin.dependencyinversion.ICourse;

public class Student {
    private ICourse iCourse;

    public Student(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    public void study(){
        iCourse.study();
    }
}
