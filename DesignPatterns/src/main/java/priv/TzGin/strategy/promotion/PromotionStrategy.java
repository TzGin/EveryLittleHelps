package priv.TzGin.strategy.promotion;

public class PromotionStrategy implements IPromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("使用优惠券抵扣");
    }
}
