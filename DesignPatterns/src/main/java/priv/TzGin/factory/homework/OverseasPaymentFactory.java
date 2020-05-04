package priv.TzGin.factory.homework;

public class OverseasPaymentFactory extends PaymentFactory{
    protected IPayment createApplePay(){
        return new ApplePay();
    }
}
