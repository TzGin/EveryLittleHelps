package priv.TzGin.composite.demo.transparent;

public class Test {

    public static void main(String[] args) {
        System.out.println("==============透明的组合模式==============");

        CourseComponent javaBase = new Course("Java入门课程", 8888D);
        CourseComponent ai = new Course("AI", 5000D);

        CourseComponent packageCourse = new CoursePackage("Java架构师课程", 2);

        CourseComponent design = new Course("Java设计模式", 1500D);
        CourseComponent source = new Course("源码分析", 2000D);
        CourseComponent softSkill = new Course("软技能", 3000D);

        packageCourse.addChild(design);
        packageCourse.addChild(source);
        packageCourse.addChild(softSkill);

        CourseComponent catalog = new CoursePackage("课程目录", 1);
        catalog.addChild(javaBase);
        catalog.addChild(ai);
        catalog.addChild(packageCourse);

        catalog.print();
    }
}
