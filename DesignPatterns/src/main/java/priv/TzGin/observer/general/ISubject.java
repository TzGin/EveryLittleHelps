package priv.TzGin.observer.general;

//抽象主题，被观察者对象
public interface ISubject<E> {

    boolean attach(IObserver<E> observer);

    boolean detach(IObserver<E> observer);

    void  notify(E event);
}
