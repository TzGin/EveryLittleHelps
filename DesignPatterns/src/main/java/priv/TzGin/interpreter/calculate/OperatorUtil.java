package priv.TzGin.interpreter.calculate;

public class OperatorUtil {

    public static boolean ifOperator(String symbol) {
        return (symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/"));
    }

    public static Interpreter getInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right, String symbol) {
        if ("+".equals(symbol)) {
            return new AddInterpreter(left, right);
        } else if ("-".equals(symbol)) {
            return new SubInterpreter(left, right);
        } else if ("*".equals(symbol)) {
            return new MulInterpreter(left, right);
        } else if ("/".equals(symbol)) {
            return new DivInterpreter(left, right);
        }
        return null;
    }
}
