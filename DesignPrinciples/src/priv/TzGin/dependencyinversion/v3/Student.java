package priv.TzGin.dependencyinversion.v3;

import priv.TzGin.dependencyinversion.ICourse;

public class Student {
    private ICourse iCourse;

    public Student(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    public void study(){
        iCourse.study();
    }
}
