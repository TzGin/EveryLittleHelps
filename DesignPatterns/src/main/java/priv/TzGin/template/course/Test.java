package priv.TzGin.template.course;

public class Test {
    public static void main(String[] args) {
        JavaCourse javaCourse = new JavaCourse();
        javaCourse.setNeedCheckHomework(true);
        javaCourse.createCourse();


        System.out.println("=============================");

        PythonCourse pythonCourse = new PythonCourse();
        pythonCourse.createCourse();
    }
}
