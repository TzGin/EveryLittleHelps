package priv.TzGin.template.course;

public class PythonCourse extends AbstractCourse {

    @Override
    protected boolean needCheckHomework() {
        return true;
    }

    @Override
    protected void checkHomework() {
        System.out.println("检查python作业");
    }
}
