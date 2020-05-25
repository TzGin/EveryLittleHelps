package priv.TzGin.mediator.general;

public class ConcreteColleagueB extends Colleague {

    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
        this.mediator.setConcreteColleagueB(this);
    }

    //自有方法: self-Method
    public void selfMethodB() {
        //处理自己的逻辑
        System.out.println(String.format("%s:self-Method", this.getClass().getSimpleName()));
    }

    //依赖方法: dep-Method
    public void depMethodB() {
        //处理自己的逻辑
        System.out.println(String.format("%s:dep-Method: delegate to Mediator", this.getClass().getSimpleName()));
        //无法处理的业务逻辑委托给中介者处理
        this.mediator.transferB();
    }
}
