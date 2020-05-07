package priv.TzGin.facade.v2;

public class FacadeService {
    private QualifyService qualifyService = new QualifyService();
    private PaymentService paymentService = new PaymentService();
    private ShippingService shippingService = new ShippingService();

    public void exchange(GiftInfo giftInfo){
        if (qualifyService.isAvailable(giftInfo)) {
            if (paymentService.pay(giftInfo)) {
                String shippingNo = shippingService.delivery(giftInfo);
                System.out.println("下单成功，订单号为" + shippingNo);
            }
        }
    }
}
