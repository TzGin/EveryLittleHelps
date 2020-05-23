package priv.TzGin.mediator.general;

//抽象中介者
public abstract class Mediator {

    protected ConcreteColleagueA concreteColleagueA;
    protected ConcreteColleagueB concreteColleagueB;

    public void setConcreteColleagueA(ConcreteColleagueA concreteColleagueA) {
        this.concreteColleagueA = concreteColleagueA;
    }

    public void setConcreteColleagueB(ConcreteColleagueB concreteColleagueB) {
        this.concreteColleagueB = concreteColleagueB;
    }

    //中介者业务逻辑
    public abstract void transferA();

    public abstract void transferB();
}
