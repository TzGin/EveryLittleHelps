package priv.TzGin.state.community;

public class UnLoginState extends UserState {
    @Override
    public void favorite() {
        switch2Login();
        this.appContext.getState().favorite();
    }

    @Override
    public void comment(String comment) {
        switch2Login();
        this.appContext.getState().comment(comment);
    }

    private void switch2Login() {
        System.out.println("跳转到登录页");
        this.appContext.setState(this.appContext.STATE_LOGIN);
    }
}
