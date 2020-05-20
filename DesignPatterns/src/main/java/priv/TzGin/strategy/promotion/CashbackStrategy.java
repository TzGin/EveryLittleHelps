package priv.TzGin.strategy.promotion;

public class CashbackStrategy implements  IPromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现，直接退回原渠道");
    }
}
