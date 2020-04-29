package priv.TzGin.openclose.v1;

import priv.TzGin.openclose.JavaCourse;

public class JavaDiscountCourse extends JavaCourse {

    private Double discount = 0.5;

    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    @Override
    public Double getPrice() {
        return super.getPrice() * discount;
    }
}
