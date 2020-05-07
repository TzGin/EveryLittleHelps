package priv.TzGin.decorator.battercake.v2;

public class Test {

    public static void main(String[] args) {
        BatterCake batterCake = new BaseBatterCake();
        System.out.println(batterCake.getMsg() + ",总价：" + batterCake.getPrice());

        batterCake = new EggDecorator(batterCake);
        System.out.println(batterCake.getMsg() + ",总价：" + batterCake.getPrice());

        batterCake = new SausageDecorator(batterCake);
        System.out.println(batterCake.getMsg() + ",总价：" + batterCake.getPrice());
    }
}
