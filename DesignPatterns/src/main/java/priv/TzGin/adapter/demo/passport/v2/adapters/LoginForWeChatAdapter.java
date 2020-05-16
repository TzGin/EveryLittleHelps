package priv.TzGin.adapter.demo.passport.v2.adapters;

import priv.TzGin.adapter.demo.passport.ResultMsg;

public class LoginForWeChatAdapter extends AbstractAdapter {
    @Override
    public boolean support(Object adapter) {
        return false;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return super.loginForRegister(id, null);
    }
}
