package priv.TzGin.chain.auth.builderchain;

import priv.TzGin.chain.auth.Member;

public class LoginHandler extends Handler {
    @Override
    public void doHandler(Member member) {
        System.out.println("登陆成功");
        member.setRoleName("管理员");
        next.doHandler(member);
    }
}
