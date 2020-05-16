package priv.TzGin.adapter.demo.passport.v1;

public class Test {

    public static void main(String[] args) {
        PassportForThirdAdapter adapter = new PassportForThirdAdapter();
        adapter.login("test", "123456");
        adapter.loginForQQ("abisjbfiabfgiouabgoiubasougb");
        adapter.loginForWeChat("oiunbaoinbfipoangpfasdagfbi");
    }
}
