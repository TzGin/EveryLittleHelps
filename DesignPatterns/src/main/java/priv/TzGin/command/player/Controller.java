package priv.TzGin.command.player;

import priv.TzGin.command.player.actions.IAction;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<IAction> actions = new ArrayList<IAction>();

    public void addActions(IAction action) {
        actions.add(action);
    }

    public void execute(IAction action) {
        action.execute();
    }

    public void executes() {
        for (IAction action : actions) {
            action.execute();
        }
        actions.clear();
    }
}
