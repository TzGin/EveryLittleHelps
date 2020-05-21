package priv.TzGin.command.player;

import priv.TzGin.command.player.actions.*;

public class Test {
    public static void main(String[] args) {
        Player player = new Player();
        Controller controller = new Controller();
        controller.execute(new PlayAction(player));

        controller.addActions(new PauseAction(player));
        controller.addActions(new PlayAction(player));
        controller.addActions(new StopAction(player));
        controller.addActions(new SpeedAction(player));
        controller.executes();
    }
}
