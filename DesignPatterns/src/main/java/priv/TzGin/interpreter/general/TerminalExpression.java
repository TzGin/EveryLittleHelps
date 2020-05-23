package priv.TzGin.interpreter.general;

public class TerminalExpression implements IExpression {

    private Object value;

    public Object interpret(Context context) {
        //实现文法中与终结符有关的操作
        context.put("", "");
        return null;
    }
}
