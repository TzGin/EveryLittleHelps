package priv.TzGin.strategy.promotion;

public class CashBackStrategy implements  IPromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现");
    }
}
