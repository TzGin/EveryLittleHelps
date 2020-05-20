package priv.TzGin.factory.homework;

public class DomesticPaymentFactory extends PaymentFactory{
    protected IPayment createAliPay(){
        return new AliPay();
    }

    protected IPayment createWeChatPay(){
        return new WechatPay();
    }

    protected IPayment createUnionPay(){
        return new UnionPay();
    }

}
