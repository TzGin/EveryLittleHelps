package priv.TzGin.command.general;

//请求者
public class Invoker {

    private ICommand command;

    public Invoker(ICommand command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }
}
