package priv.TzGin.composite.demo.transparent;

public class Course extends CourseComponent{

    private CoursePackage coursePackage;
    private String name;
    private double price;

    public Course(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(CourseComponent component) {
        return name;
    }

    @Override
    public double getPrice(CourseComponent component) {
        return price;
    }

    @Override
    public void print() {
        System.out.println(name + "(￥" + price + "元)");
    }
}
