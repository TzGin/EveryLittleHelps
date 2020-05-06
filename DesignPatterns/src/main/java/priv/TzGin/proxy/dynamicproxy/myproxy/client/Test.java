package priv.TzGin.proxy.dynamicproxy.myproxy.client;

public class Test {

    public static void main(String[] args) {
        ConcreteProxy meipo = new ConcreteProxy();
        IPerson zhangsan = meipo.getInstance(new ZhangSan());
        zhangsan.findLove(28);
    }
}
