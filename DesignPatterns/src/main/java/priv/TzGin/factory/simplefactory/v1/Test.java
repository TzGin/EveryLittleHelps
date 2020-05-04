package priv.TzGin.factory.simplefactory.v1;

/**
 * 创建其他课程时需要复制Course类且只修改了课程名称
 * 违背了开闭原则
 */

public class Test {
    public static void main(String[] args) {
        Course course = new Course();
        course.record();
    }
}
