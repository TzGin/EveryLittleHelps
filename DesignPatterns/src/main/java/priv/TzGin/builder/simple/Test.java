package priv.TzGin.builder.simple;

public class Test {

    public static void main(String[] args) {
        CourseBuilder builder = new CourseBuilder();
        builder.addName("设计模式");
        builder.addVideo("视频");
        builder.addNote("笔记");
        builder.addHomework("作业");
        System.out.println(builder.builder());
    }
}
