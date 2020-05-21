package priv.TzGin.chain.auth.optimiaze;

import priv.TzGin.chain.auth.Member;

public class MemberService {

    public void login(String loginName, String loginPass) {
        Handler validateHandler = new ValidateHandler();
        Handler loginHandler = new LoginHandler();
        Handler authHandler = new AuthHandler();

        validateHandler.setNext(loginHandler);
        loginHandler.setNext(authHandler);

        validateHandler.doHandler(new Member(loginName, loginPass));
    }
}
