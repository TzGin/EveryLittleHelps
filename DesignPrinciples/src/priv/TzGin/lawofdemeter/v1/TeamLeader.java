package priv.TzGin.lawofdemeter.v1;

import priv.TzGin.lawofdemeter.Course;

import java.util.ArrayList;
import java.util.List;

public class TeamLeader {
    public void commandCheckNumber(Employee employee){
        List<Course> courseList = new ArrayList<Course>();
        for (int i = 0; i < 20; i++) {
            courseList.add(new Course());
        }
        employee.checkNumberCourses(courseList);
    }
}
