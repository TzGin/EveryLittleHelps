package priv.TzGin.builder.chain;

public class Test {

    public static void main(String[] args) {
        CourseBuilder builder = new CourseBuilder();
        builder.addName("设计模式")
                .addVideo("视频")
                .addNote("笔记")
                .addHomework("作业");
        System.out.println(builder.builder());
    }
}
