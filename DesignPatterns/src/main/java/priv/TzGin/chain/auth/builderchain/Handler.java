package priv.TzGin.chain.auth.builderchain;

import priv.TzGin.chain.auth.Member;

public abstract class Handler<T> {

    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void doHandler(Member member);

    public static class Builder<T> {
        private Handler<T> head;
        private Handler<T> tail;

        public Builder<T> addHandler(Handler<T> handler) {
            if (head == null) {
                head = tail = handler;
                return this;
            }
            this.tail.setNext(handler);
            this.tail = handler;
            return this;
        }

        public Handler<T> build() {
            return this.head;
        }
    }
}
