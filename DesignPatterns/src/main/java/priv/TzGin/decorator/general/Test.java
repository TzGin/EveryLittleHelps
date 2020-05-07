package priv.TzGin.decorator.general;

public class Test {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();  //首先创建需要被装饰的原始对象(即要被装饰的对象)
        Decorator decoratorA = new ConcreteDecoratorA(component);   //给对象透明的增加功能A并调用
        decoratorA.operation();
        Decorator decoratorB = new ConcreteDecoratorB(component);   //给对象透明的增加功能B并调用
        decoratorB.operation();
        Decorator decoratorAandB = new ConcreteDecoratorB(decoratorA);  //装饰器也可以装饰具体的装饰
        decoratorAandB.operation();
    }
}
