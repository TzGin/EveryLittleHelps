package priv.TzGin.visitor.kpi;

import java.util.Random;

public class Manager extends Employee {

    public Manager(String name) {
        super(name);
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    //考核指标是每年新产品研发数量
    public int getProducts() {
        return new Random().nextInt(10);
    }
}
