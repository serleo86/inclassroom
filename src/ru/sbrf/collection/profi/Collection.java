package ru.sbrf.collection.profi;

public interface Collection<Type> {
    int size();

    boolean isEmpty();

    boolean contains(Type item);

    boolean add(Type item);

    boolean remove(Type item);

    void clear();
}
