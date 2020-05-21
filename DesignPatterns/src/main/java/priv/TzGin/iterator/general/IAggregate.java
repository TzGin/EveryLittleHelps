package priv.TzGin.iterator.general;

public interface IAggregate<E> {

    boolean add(E e);

    boolean remove(E e);

    Iterator<E> iterator();
}
