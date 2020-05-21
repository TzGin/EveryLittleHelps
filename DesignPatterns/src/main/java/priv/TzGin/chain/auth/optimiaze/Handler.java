package priv.TzGin.chain.auth.optimiaze;

import priv.TzGin.chain.auth.Member;

public abstract class Handler {

    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void doHandler(Member member);
}
