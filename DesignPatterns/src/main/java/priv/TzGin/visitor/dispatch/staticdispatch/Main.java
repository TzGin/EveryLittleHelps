package priv.TzGin.visitor.dispatch.staticdispatch;

//静态分派，编译时就能确定类型
//重载test称为多分派
public class Main {

    public void test(String string) {
        System.out.println("string" + string);
    }

    public void test(Integer integer) {
        System.out.println("integer" + integer);
    }

    public static void main(String[] args) {
        String string  = "1";
        Integer integer = 1;
        Main main = new Main();
        main.test(integer);
        main.test(string);
    }
}
