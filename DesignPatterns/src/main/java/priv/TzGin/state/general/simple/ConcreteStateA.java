package priv.TzGin.state.general.simple;

public class ConcreteStateA implements IState {
    @Override
    public void handle() {
        //必要时刻需要进行状态切换
        System.out.println("StateA do action");
    }
}
