package priv.TzGin.bridge.general;

public class Test {

    public static void main(String[] args) {
        //创建一个实现化角色
        IImplementor implementor = new ConcreteImplementorA();
        //创建一个抽象化实现，聚合实现
        Abstraction abstraction = new RefinedAbstraction(implementor);
        //执行操作
        abstraction.operation();
    }
}
