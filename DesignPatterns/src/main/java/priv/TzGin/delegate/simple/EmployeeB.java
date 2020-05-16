package priv.TzGin.delegate.simple;

public class EmployeeB implements IEmployee {

    private String goodAt = "平面设计";

    @Override
    public void doing(String task) {
        System.out.println("我是员工B，我擅长" + goodAt + ",现在开始做" + task + "工作");
    }
}
