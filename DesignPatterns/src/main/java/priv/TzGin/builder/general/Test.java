package priv.TzGin.builder.general;

public class Test {
    public static void main(String[] args) {
        IBuilder builder = new ConcreteBuilder();
        System.out.println(builder.build());
    }
}
