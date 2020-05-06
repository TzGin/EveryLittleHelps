package priv.TzGin.proxy.dynamicproxy.myproxy.client;

public class ZhangSan implements IPerson {

    @Override
    public void findLove(int age) {
        System.out.println("张三要求：白富美,年龄小于 " + age);
    }
}
