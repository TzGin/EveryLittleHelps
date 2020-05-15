package priv.TzGin.adapter.demo.classadapter;

public class Test {

    public static void main(String[] args) {
        PowerAdapter adapter = new PowerAdapter();
        adapter.output5V();
        adapter.outputAC220V(); //违背最少知道原则
    }
}
