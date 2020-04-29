package priv.TzGin.dependencyinversion.v4;

import priv.TzGin.dependencyinversion.ICourse;

public class Student {
    private ICourse iCourse;

    public void setICourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    public void study(){
        iCourse.study();
    }
}
