package priv.TzGin.facade.v2;

public class Test {

    public static void main(String[] args) {
        GiftInfo giftInfo = new GiftInfo("Java设计模式");
        FacadeService facadeService = new FacadeService();
        facadeService.exchange(giftInfo);
    }
}
