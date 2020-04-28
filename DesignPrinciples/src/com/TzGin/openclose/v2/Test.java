package com.TzGin.openclose.v2;

import com.TzGin.openclose.ICourse;

public class Test {
    public static void main(String[] args) {
        ICourse iCourse = new JavaDiscountCourse(1, "Java", 1000D);
        JavaDiscountCourse discountCourse = (JavaDiscountCourse)iCourse;
        System.out.println("课程ID: " + discountCourse.getId() +
                "\n课程标题: " + discountCourse.getName() +
                "\n原价: " + discountCourse.getPrice() +
                "\n售价: " + discountCourse.getDiscountPrice());
    }
}
