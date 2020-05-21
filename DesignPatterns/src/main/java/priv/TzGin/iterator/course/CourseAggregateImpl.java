package priv.TzGin.iterator.course;

import java.util.ArrayList;
import java.util.List;

public class CourseAggregateImpl implements ICourseAggregate {

    private List<Course> courseList;

    public CourseAggregateImpl() {
        courseList = new ArrayList<Course>();
    }

    @Override
    public void add(Course course) {
        courseList.add(course);
    }

    @Override
    public void remove(Course course) {
        courseList.remove(course);
    }

    @Override
    public Iterator<Course> iterator() {
        return new IteratorImpl<Course>(courseList);
    }
}
