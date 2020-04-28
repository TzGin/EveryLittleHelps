package com.TzGin.dependencyinversion;

import com.TzGin.dependencyinversion.ICourse;

public class PythonCourse implements ICourse {
    @Override
    public void study() {
        System.out.println("Student正在学习Python课程");
    }
}
