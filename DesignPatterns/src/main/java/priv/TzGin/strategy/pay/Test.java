package priv.TzGin.strategy.pay;

public class Test {
    public static void main(String[] args) {
        Order order = new Order("1", "20200520012200020", 520);
        System.out.println(order.pay("AliPay"));
        System.out.println("=============================");
        System.out.println(order.pay("UnionPay"));
    }
}
