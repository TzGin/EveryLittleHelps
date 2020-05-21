package priv.TzGin.iterator.general;

import java.util.ArrayList;
import java.util.List;

//具体容器
public class ConcreteAggregate<E> implements IAggregate<E> {

    private List<E> list = new ArrayList<E>();

    @Override
    public boolean add(E e) {
        return list.add(e);
    }

    @Override
    public boolean remove(E e) {
        return list.remove(e);
    }

    @Override
    public Iterator<E> iterator() {
        return new ConcreteIterator<E>(list);
    }
}
