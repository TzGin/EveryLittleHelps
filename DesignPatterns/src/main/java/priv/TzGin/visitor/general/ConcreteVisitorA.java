package priv.TzGin.visitor.general;

//具体访问者
public class ConcreteVisitorA implements IVisitor {

    public void visit(ConcreteElementA elementA) {
        String result = elementA.operationA();
        System.out.println("result from " + elementA.getClass().getSimpleName() + ": " + result);
    }

    public void visit(ConcreteElementB elementB) {
        String result = elementB.operationB();
        System.out.println("result from " + elementB.getClass().getSimpleName() + ": " + result);
    }
}
