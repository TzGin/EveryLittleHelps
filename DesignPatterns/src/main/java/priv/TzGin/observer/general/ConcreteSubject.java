package priv.TzGin.observer.general;

import java.util.ArrayList;
import java.util.List;

//具体主题
public class ConcreteSubject<E> implements ISubject<E> {

    private List<IObserver<E>> observers = new ArrayList<IObserver<E>>();


    public boolean attach(IObserver<E> observer) {
        if (observers.contains(observer)) return false;
        observers.add(observer);
        return true;
    }

    public boolean detach(IObserver<E> observer) {
        return observers.remove(observer);
    }

    public void notify(E event) {
        for (IObserver<E> observer : observers) {
            observer.update(event);
        }
    }
}
