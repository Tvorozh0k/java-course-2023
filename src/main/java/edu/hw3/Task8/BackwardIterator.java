package edu.hw3.Task8;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class BackwardIterator<T> implements Iterator<T> {
    private final ListIterator<T> backwardIterator;

    public BackwardIterator(Collection<T> collection) {
        List<T> list = List.copyOf(collection);
        this.backwardIterator = list.listIterator(list.size());
    }

    @Override
    public boolean hasNext() {
        return backwardIterator.hasPrevious();
    }

    @Override
    public T next() {
        return backwardIterator.previous();
    }

    @Override
    public void remove() {
        backwardIterator.remove();
    }
}
