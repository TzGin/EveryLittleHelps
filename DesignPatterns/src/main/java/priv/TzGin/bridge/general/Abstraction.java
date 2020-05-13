package priv.TzGin.bridge.general;

//抽象
public abstract class Abstraction {

    protected IImplementor iImplementor;

    public Abstraction(IImplementor iImplementor) {
        this.iImplementor = iImplementor;
    }

    public void operation() {
        iImplementor.operationImpl();
    }
}
