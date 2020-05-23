package priv.TzGin.interpreter.calculate;

//终结表达式
public class NumberInterpreter implements IArithmeticInterpreter {

    private int value;

    public NumberInterpreter(int value) {
        this.value = value;
    }

    public int interpret() {
        return value;
    }
}
