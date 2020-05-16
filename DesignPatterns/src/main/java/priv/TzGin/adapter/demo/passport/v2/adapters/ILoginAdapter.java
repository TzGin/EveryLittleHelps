package priv.TzGin.adapter.demo.passport.v2.adapters;

import priv.TzGin.adapter.demo.passport.ResultMsg;

public interface ILoginAdapter {

    boolean support(Object adapter);

    ResultMsg login(String id, Object adapter);


}
