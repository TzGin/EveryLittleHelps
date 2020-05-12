package priv.TzGin.composite.demo.transparent;

public class CourseComponent {

    public void addChild(CourseComponent component) {
        throw new UnsupportedOperationException("不允许添加操作");
    }

    public void removeChild(CourseComponent component) {
        throw new UnsupportedOperationException("不允许删除操作");
    }

    public String getName(CourseComponent component) {
        throw new UnsupportedOperationException("不允许获取名称");
    }

    public double getPrice(CourseComponent component) {
        throw new UnsupportedOperationException("不允许获取价格");
    }

    public void print() {
        throw new UnsupportedOperationException("不允许打印");
    }
}
