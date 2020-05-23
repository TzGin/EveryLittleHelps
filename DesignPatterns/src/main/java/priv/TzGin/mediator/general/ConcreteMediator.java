package priv.TzGin.mediator.general;

//具体中介者
public class ConcreteMediator extends Mediator {

    public void transferA() {
        //协调行为：A 转发到 B
        this.concreteColleagueB.selfMethodB();
    }

    public void transferB() {
        //协调行为：B 转发到A
        this.concreteColleagueA.selfMethodA();
    }
}
