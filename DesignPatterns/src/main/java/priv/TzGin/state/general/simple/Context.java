package priv.TzGin.state.general.simple;

public class Context {

    private static final IState STATE_A = new ConcreteStateA();
    private static final IState STATE_B = new ConcreteStateB();

    //默认状态A
    private IState currentState = STATE_A;

    public void setState(IState state) {
        this.currentState = state;
    }

    public void handle() {
        this.currentState.handle();
    }
}
