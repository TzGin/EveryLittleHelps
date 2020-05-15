package priv.TzGin.adapter.demo.interfaceadapter;

public class Test {

    public static void main(String[] args) {
        DC adapter = new PowerAdapter(new AC220());
        adapter.output5V(); //违背单一职责原则;
    }
}
