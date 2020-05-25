package priv.TzGin.visitor.general;

public class ConcreteVisitorB implements IVisitor {

    public void visit(ConcreteElementA elementA) {
        String result = elementA.operationA();
        System.out.println("result from " + elementA.getClass().getSimpleName() + ": " + result);
    }

    public void visit(ConcreteElementB elementB) {
        String result = elementB.operationB();
        System.out.println("result from " + elementB.getClass().getSimpleName() + ": " + result);
    }
}
