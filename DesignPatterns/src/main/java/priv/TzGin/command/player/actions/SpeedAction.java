package priv.TzGin.command.player.actions;

import priv.TzGin.command.player.Player;

public class SpeedAction implements IAction {

    private Player player;

    public SpeedAction(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.speed();
    }
}
