package priv.TzGin.command.player.actions;

import priv.TzGin.command.player.Player;

public class PauseAction implements IAction {

    private Player player;

    public PauseAction(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.pause();
    }
}
