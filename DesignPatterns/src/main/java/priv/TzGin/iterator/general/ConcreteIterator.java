package priv.TzGin.iterator.general;

import java.util.List;

//具体迭代器
public class ConcreteIterator<E> implements Iterator<E> {

    private List<E> list;
    private int cursor = 0;

    public ConcreteIterator(List<E> list) {
        this.list = list;
    }

    @Override
    public E next() {
        return list.get(cursor++);
    }

    @Override
    public boolean hasNext() {
        return cursor != list.size();
    }
}
