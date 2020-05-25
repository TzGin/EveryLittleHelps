package priv.TzGin.visitor.general;

public class ConcreteElementB implements IElement {

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public String operationB() {
        return this.getClass().getSimpleName();
    }
}
