package com.TzGin.dependencyinversion.v4;

import com.TzGin.dependencyinversion.ICourse;

public class Student {
    private ICourse iCourse;

    public void setICourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    public void study(){
        iCourse.study();
    }
}
