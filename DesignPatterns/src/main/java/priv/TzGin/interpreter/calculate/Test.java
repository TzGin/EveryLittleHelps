package priv.TzGin.interpreter.calculate;

public class Test {
    public static void main(String[] args) {
        //这里没有对括号进行优先级处理
        System.out.println("result:" + new MyCalculator("100 * 2 + 400 + 66").calculate());
    }
}
