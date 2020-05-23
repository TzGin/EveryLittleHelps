package priv.TzGin.interpreter.calculate;

import java.util.Stack;

public class MyCalculator {

    private Stack<IArithmeticInterpreter> stack = new Stack<IArithmeticInterpreter>();

    public MyCalculator(String expression) {
        parse(expression);
    }

    //约定表达式用空格隔开
    public void parse(String expression) {
        String[] elements = expression.split(" ");
        IArithmeticInterpreter left, right;

        for (int i = 0; i < elements.length; i++) {
            String operator = elements[i];
            if (OperatorUtil.ifOperator(operator)) {
                left = stack.pop();
                right = new NumberInterpreter(Integer.parseInt(elements[++i]));
                System.out.println("出栈：" + left.interpret() + " 和 " + right.interpret());
                stack.push(OperatorUtil.getInterpreter(left, right, operator));
                System.out.println("应用运算符：" + operator);
            }else {
                NumberInterpreter numberInterpreter = new NumberInterpreter(Integer.parseInt(operator));
                stack.push(numberInterpreter);
                System.out.println("入栈：" + numberInterpreter.interpret());
            }
        }
    }

    public int calculate() {
        return stack.pop().interpret();
    }
}
