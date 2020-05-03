package priv.TzGin.factorypattern.homework;

public class DomesticPaymentFactory extends PaymentFactory{
    protected IPayment createAliPay(){
        return new AliPay();
    }

    protected IPayment createWeChatPay(){
        return new WeChatPay();
    }

    protected IPayment createUnionPay(){
        return new UnionPay();
    }

}
