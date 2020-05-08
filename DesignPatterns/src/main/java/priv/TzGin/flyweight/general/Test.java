package priv.TzGin.flyweight.general;

public class Test {

    public static void main(String[] args) {
        String intrinsicState = "内部状态";
        IFlyweight flyweight = FlyweightFactory.getFlyweight(intrinsicState);
        flyweight.operation("新增外部状态");
    }
}
