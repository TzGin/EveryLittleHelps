package priv.TzGin.decorator.general;

public class ConcreteDecoratorB extends Decorator{
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    private void operationFirst(){System.out.println("附加功能B在operation之前");} //在调用父类的operation方法之前需要执行的操作
    private void operationLast(){System.out.println("附加功能B在operation之后");}  //在调用父类的operation方法之后需要执行的操作

    @Override
    public void operation() {
        //调用父类的方法，可以再调用前后执行一些附加动作
        operationFirst();   //添加的功能
        super.operation();  //这里可以选择性的调用父类的方法，如果不调用则相当于完全改写了方法
        operationLast();    //添加的功能
    }
}
