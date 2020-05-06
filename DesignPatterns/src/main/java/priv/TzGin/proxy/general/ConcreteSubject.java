package priv.TzGin.proxy.general;

public class ConcreteSubject implements ISubject {

    public void request() {
        System.out.println("read service is called");
    }
}
