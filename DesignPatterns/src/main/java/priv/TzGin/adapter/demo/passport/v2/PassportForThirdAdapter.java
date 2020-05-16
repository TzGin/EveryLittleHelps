package priv.TzGin.adapter.demo.passport.v2;

import priv.TzGin.adapter.demo.passport.ResultMsg;
import priv.TzGin.adapter.demo.passport.v2.adapters.ILoginAdapter;
import priv.TzGin.adapter.demo.passport.v2.adapters.LoginForQQAdapter;
import priv.TzGin.adapter.demo.passport.v2.adapters.LoginForTelephone;
import priv.TzGin.adapter.demo.passport.v2.adapters.LoginForWeChatAdapter;

public class PassportForThirdAdapter implements IPassportForThird {

    @Override
    public ResultMsg loginForQQ(String openId) {
        return processLogin(openId, LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWeChat(String openId) {
        return processLogin(openId, LoginForWeChatAdapter.class);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return processLogin(token, LoginForTelephone.class);
    }

    @Override
    public ResultMsg loginForTelephone(String phone, String code) {
        return processLogin(phone, LoginForTelephone.class);
    }

    private ResultMsg processLogin(String id, Class<? extends ILoginAdapter> clazz) {
        try {
            ILoginAdapter adapter = clazz.newInstance();
            if (adapter.support(adapter)) {
                return adapter.login(id, adapter);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
