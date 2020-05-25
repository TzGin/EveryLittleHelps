package priv.TzGin.visitor.kpi;

public class CEOVisitor implements IVisitor {

    public void visit(Engineer engineer) {
        System.out.println("工程师：" + engineer.name + "，KPI:" + engineer.kpi);
    }

    public void visit(Manager manager) {
        System.out.println("产品经理：" + manager.name + "，KPI：" + manager.kpi);
    }
}
