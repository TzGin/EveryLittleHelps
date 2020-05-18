package priv.TzGin.strategy.promotion;

public class PromotionStrategyFactory {
    private PromotionStrategyFactory() {

    }

    public static IPromotionStrategy getPromotionStrategy(String promotionKey) {
        return null;
    }

    private interface  PromotionKey {
        String COUPON = "COUPON";
        String CASHBACK = "CASHBACK";
        String GROUPBUY = "GROUPBUY";
    }
}
