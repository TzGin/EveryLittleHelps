package priv.TzGin.observer.general;

//抽象观察者,被通知对象
public interface IObserver<E> {

    void update(E e);
}
