package priv.TzGin.state.general.simple;

public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new ConcreteStateB());
        context.handle();
    }
}
