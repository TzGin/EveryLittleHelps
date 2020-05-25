package priv.TzGin.visitor.kpi;

public interface IVisitor {

    //没有写成抽象类，是因为将访问者严格区分出来，增加访问者只需要简单修改，职责单一化
    //动态的单分派
    void visit(Engineer engineer);

    void visit(Manager manager);
}
