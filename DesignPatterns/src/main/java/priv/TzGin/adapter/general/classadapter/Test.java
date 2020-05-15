package priv.TzGin.adapter.general.classadapter;

public class Test {
    public static void main(String[] args) {
        Target adapter = new Adapter();
        int result = adapter.request();
        System.out.println(result);
    }
}
