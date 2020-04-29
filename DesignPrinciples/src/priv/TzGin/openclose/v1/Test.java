package priv.TzGin.openclose.v1;

import priv.TzGin.openclose.ICourse;

public class Test {
    public static void main(String[] args) {
        ICourse iCourse = new JavaDiscountCourse(1, "Java", 1000D);
        System.out.println("课程ID: " + iCourse.getId() +
                "\n课程标题: " + iCourse.getName() +
                "\n售价: " + iCourse.getPrice());
    }
}
