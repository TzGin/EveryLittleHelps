package priv.TzGin.strategy.pay.payport;

public class UnionPay extends Payment {

    public String getName() {
        return "银联";
    }

    protected double queryBalance(String uid) {
        return 125;
    }
}
