package priv.TzGin.adapter.demo.passport.v2.adapters;

import priv.TzGin.adapter.demo.passport.PassportService;
import priv.TzGin.adapter.demo.passport.ResultMsg;

public abstract class AbstractAdapter extends PassportService implements ILoginAdapter {

    protected ResultMsg loginForRegister(String username, String password) {
        if (null == password) {
            password = "THIRD_EMPTY";
        }
        super.register(username, password);
        return super.login(username, password);
    }
}
