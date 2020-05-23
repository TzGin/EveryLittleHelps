package priv.TzGin.interpreter.calculate;

public class MulInterpreter extends Interpreter {
    public MulInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return this.left.interpret() * this.right.interpret();
    }
}
