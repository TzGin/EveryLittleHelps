package priv.TzGin.factorypattern.homework;

public class OverseasPaymentFactory extends PaymentFactory{
    protected IPayment createApplePay(){
        return new ApplePay();
    }
}
