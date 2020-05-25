package priv.TzGin.visitor.general;

public class Test {
    public static void main(String[] args) {
        ObjectStructure collection = new ObjectStructure();
        System.out.println("ConcreteVisitorA handle elements:");
        IVisitor visitorA = new ConcreteVisitorA();
        collection.accept(visitorA);
        System.out.println("ConcreteVisitorB handle elements:");
        IVisitor visitorB = new ConcreteVisitorB();
        collection.accept(visitorB);
    }
}
