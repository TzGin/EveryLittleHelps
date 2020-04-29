package priv.TzGin.lawofdemeter.v1;

import priv.TzGin.lawofdemeter.Course;

import java.util.List;

public class Employee {
    public void checkNumberCourses(List<Course> courseList){
        System.out.println("目前发布的课程数量为: " + courseList.size());
    }
}
