package priv.TzGin.openclose.v2;

import priv.TzGin.openclose.JavaCourse;

public class JavaDiscountCourse extends JavaCourse {
    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    public Double getDiscountPrice() {
        return super.getPrice() * 0.5;
    }
}
