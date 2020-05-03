package priv.TzGin.factorypattern.homework;

public class Test {
    public static void main(String[] args) {
        DomesticPaymentFactory domesticPaymentFactory = new DomesticPaymentFactory();
        domesticPaymentFactory.createAliPay().pay();
        domesticPaymentFactory.createWeChatPay().pay();
        domesticPaymentFactory.createUnionPay().pay();

        OverseasPaymentFactory overseasPaymentFactory = new OverseasPaymentFactory();
        overseasPaymentFactory.createApplePay().pay();
    }
}
