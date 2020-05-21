package priv.TzGin.iterator.course;

public class Test {
    public static void main(String[] args) {
        Course java = new Course("Java");
        Course python = new Course("Python");
        Course design = new Course("Design");

        ICourseAggregate aggregate = new CourseAggregateImpl();
        aggregate.add(java);
        aggregate.add(python);
        aggregate.add(design);

        System.out.println("============课程列表==============");
        printCourse(aggregate);

        System.out.println("============删除课程之后的课程列表==============");
        aggregate.remove(python);
        printCourse(aggregate);
    }

    private static void printCourse(ICourseAggregate aggregate) {
        Iterator<Course> iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            Course course = iterator.next();
            System.out.println(course.getName());
        }
    }
}
