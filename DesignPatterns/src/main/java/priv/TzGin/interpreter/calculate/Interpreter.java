package priv.TzGin.interpreter.calculate;

//非终结表达式抽象
public abstract class Interpreter implements IArithmeticInterpreter {

    protected IArithmeticInterpreter left;
    protected IArithmeticInterpreter right;

    public Interpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        this.left = left;
        this.right = right;
    }

    public int interpret() {
        return 0;
    }
}
