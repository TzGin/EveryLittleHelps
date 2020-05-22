package priv.TzGin.state.general.apply;

//具体状态
public class ConcreteStateA extends State {
    @Override
    public void handle() {
        //必要时刻需要进行状态切换
        System.out.println("StateA do action");
    }
}
