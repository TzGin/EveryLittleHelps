package priv.TzGin.builder.simple;

public class CourseBuilder {

    private Course course = new Course();

    public void addName(String name) {
        course.setName(name);
    }

    public void addVideo(String video) {
        course.setVideo(video);
    }

    public void addNote(String note) {
        course.setNote(note);
    }

    public void addHomework(String homework) {
        course.setHomework(homework);
    }

    public Course builder() {
        return course;
    }
}
