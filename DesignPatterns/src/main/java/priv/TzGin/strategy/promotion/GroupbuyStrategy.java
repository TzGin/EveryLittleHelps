package priv.TzGin.strategy.promotion;

public class GroupbuyStrategy implements IPromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("5人拼团，可以优惠");
    }
}
