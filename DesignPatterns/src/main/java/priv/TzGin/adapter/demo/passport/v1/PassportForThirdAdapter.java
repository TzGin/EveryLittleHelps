package priv.TzGin.adapter.demo.passport.v1;

import priv.TzGin.adapter.demo.passport.PassportService;
import priv.TzGin.adapter.demo.passport.ResultMsg;

public class PassportForThirdAdapter extends PassportService implements IPassportForThird{

    @Override
    public ResultMsg loginForQQ(String openId) {
        return loginForRegister(openId, null);
    }

    @Override
    public ResultMsg loginForWeChat(String openId) {
        return loginForRegister(openId, null);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return loginForRegister(token, null);
    }

    @Override
    public ResultMsg loginForTelephone(String phone, String code) {
        return loginForRegister(phone, null);
    }

    private ResultMsg loginForRegister(String username, String password) {
        if (null == password) {
            password = "THIRD_EMPTY";
        }
        super.register(username, password);
        return super.login(username, password);
    }
}
