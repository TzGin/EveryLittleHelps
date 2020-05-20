package priv.TzGin.strategy.pay.payport;

import priv.TzGin.strategy.pay.MsgResult;

public abstract class Payment {

    public abstract String getName();

    protected abstract double queryBalance(String uid);

    //通用逻辑放到抽象类里实现
    public MsgResult pay(String uid, double amount) {
        //查询余额是否足够
        if (queryBalance(uid) < amount) {
            return new MsgResult(500, "支付失败", "余额不足");
        }
        return new MsgResult(200, "支付成功", "支付金额" + amount);
    }
}
