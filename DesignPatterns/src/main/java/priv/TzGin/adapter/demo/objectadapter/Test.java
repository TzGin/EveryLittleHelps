package priv.TzGin.adapter.demo.objectadapter;

public class Test {

    public static void main(String[] args) {
        PowerAdapter adapter = new PowerAdapter(new AC220());
        adapter.output5V();
    }
}
