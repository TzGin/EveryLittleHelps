package priv.TzGin.visitor.kpi;

import java.util.Random;

public abstract class Employee {

    public String name;
    public int kpi; //员工kpi

    public Employee(String name) {
        this.name = name;
        kpi = new Random().nextInt(10);
    }

    //接收访问者的访问
    public abstract void accept(IVisitor visitor);
}
