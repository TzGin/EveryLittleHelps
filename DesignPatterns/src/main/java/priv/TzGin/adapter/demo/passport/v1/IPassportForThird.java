package priv.TzGin.adapter.demo.passport.v1;

import priv.TzGin.adapter.demo.passport.ResultMsg;

public interface IPassportForThird {

    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWeChat(String openId);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTelephone(String phone, String code);
}
