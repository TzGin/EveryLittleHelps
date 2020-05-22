package priv.TzGin.state.community;

public class AppContext {

    public static final UserState STATE_LOGIN = new LoginState();
    public static final UserState STATE_UNLOGIN = new UnLoginState();

    private UserState currentState = STATE_UNLOGIN;

    {
        STATE_LOGIN.setAppContext(this);
        STATE_UNLOGIN.setAppContext(this);
    }

    public void setState(UserState state) {
        this.currentState = state;
    }

    public UserState getState() {
        return currentState;
    }

    public void favorite() {
        currentState.favorite();
    }

    public void comment(String comment) {
        currentState.comment(comment);
    }
}
