package priv.TzGin.singleton.register;

public class ContainerSingletonTest {

    public static void main(String[] args) {
        Object instace1 = ContainerSingleton.getInstance("priv.TzGin.singleton.register.TestPojo");
        Object instace2 = ContainerSingleton.getInstance("priv.TzGin.singleton.register.TestPojo");
        System.out.println(instace1);
        System.out.println(instace2);
        System.out.println(instace1 == instace2);
    }
}
