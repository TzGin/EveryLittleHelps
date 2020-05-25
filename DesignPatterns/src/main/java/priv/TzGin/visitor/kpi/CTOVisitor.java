package priv.TzGin.visitor.kpi;

public class CTOVisitor implements IVisitor {

    public void visit(Engineer engineer) {
        System.out.println("工程师：" + engineer.name + "，代码行数:" + engineer.getCodeLines());
    }

    public void visit(Manager manager) {
        System.out.println("产品经理：" + manager.name + "，产品数量：" + manager.getProducts());
    }
}
