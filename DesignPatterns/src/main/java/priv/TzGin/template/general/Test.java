package priv.TzGin.template.general;

public class Test {
    public static void main(String[] args) {
        AbstractClass abc = new ConcreteClassA();
        abc.templateMethod();
        System.out.println("====================");
        abc = new ConcreteClassB();
        abc.templateMethod();
    }
}
