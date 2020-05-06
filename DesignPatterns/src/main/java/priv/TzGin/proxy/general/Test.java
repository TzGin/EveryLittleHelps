package priv.TzGin.proxy.general;

public class Test {

    public static void main(String[] args) {
        ISubject subject = new ConcreteSubject();
        Proxy proxy = new Proxy(subject);
        proxy.request();
    }
}
