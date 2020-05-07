package priv.TzGin.facade.v1;

public class Test {

    public static void main(String[] args) {
        GiftInfo giftInfo = new GiftInfo("Java设计模式");

        QualifyService qualifyService = new QualifyService();
        PaymentService paymentService = new PaymentService();
        ShippingService shippingService = new ShippingService();

        if (qualifyService.isAvailable(giftInfo)) {
            if (paymentService.pay(giftInfo)) {
                String shippingNo = shippingService.delivery(giftInfo);
                System.out.println("下单成功，订单号为" + shippingNo);
            }
        }
    }
}
