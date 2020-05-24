package priv.TzGin.observer.general;

public class ConcreteObserver<E> implements IObserver<E> {

    public void update(E event) {
        System.out.println("receive event:" + event);
    }
}
