package priv.TzGin.delegate.simple;

public class EmployeeA implements IEmployee {

    private String goodAt = "编程";

    @Override
    public void doing(String task) {
        System.out.println("我是员工A，我擅长" + goodAt + ",现在开始做" + task + "工作");
    }
}
