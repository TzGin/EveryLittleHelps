package priv.TzGin.visitor.dispatch.dynamicdispatch;

//动态分派，在运行时才能确定类型
public class Test {
    public static void main(String[] args) {
        Person man = new Man();
        Person woman = new Woman();

        man.test();
        woman.test();
    }
}
