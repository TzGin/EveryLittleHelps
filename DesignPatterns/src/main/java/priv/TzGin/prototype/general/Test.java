package priv.TzGin.prototype.general;

public class Test {

    public static void main(String[] args) {
        ConcretePrototype concretePrototype = new ConcretePrototype();
        concretePrototype.setAge(18);
        concretePrototype.setName("TzGin");
        System.out.println(concretePrototype);

        ConcretePrototype clone = concretePrototype.clone();
        System.out.println(clone);
    }
}
