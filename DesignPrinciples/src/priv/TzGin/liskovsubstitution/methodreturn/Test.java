package priv.TzGin.liskovsubstitution.methodreturn;

public class Test {
    public static void main(String[] args) {
        Base base = new Child();
        System.out.println(base.method());

        Child child = new Child();
        System.out.println(child.method());
    }
}
