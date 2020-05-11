package priv.TzGin.flyweight.jdk;

public class IntegerTest {

    public static void main(String[] args) {
        Integer a = Integer.valueOf(127);
        Integer b = 127;

        Integer c = Integer.valueOf(128);
        Integer d = 128;

        System.out.println(a == b); //true  -128~127会缓存
        System.out.println(c == d); //false <-128 || > 127 会直接new Integer
    }
}
