package priv.TzGin.strategy.promotion;

public class Test {
    public static void main(String[] args) {
        System.out.println(PromotionStrategyFactory.getPromotionKeys());

        String promotion = "COUPON";
        IPromotionStrategy promotionStrategy = PromotionStrategyFactory.getPromotionStrategy(promotion);
        promotionStrategy.doPromotion();
    }
}
