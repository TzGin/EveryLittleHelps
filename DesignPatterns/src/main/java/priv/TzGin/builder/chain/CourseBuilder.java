package priv.TzGin.builder.chain;

public class CourseBuilder {

    private Course course = new Course();

    public CourseBuilder addName(String name) {
        course.setName(name);
        return this;
    }

    public CourseBuilder addVideo(String video) {
        course.setVideo(video);
        return this;
    }

    public CourseBuilder addNote(String note) {
        course.setNote(note);
        return this;
    }

    public CourseBuilder addHomework(String homework) {
        course.setHomework(homework);
        return this;
    }

    public Course builder() {
        return course;
    }
}
