package ru.sbrf.collection.profi;

public interface List<Type> extends Collection<Type> {
    void add(int index, Type item);

    void set(int index, Type item);

    Object get(int index);

    int indexOf(Type item);

    int lastIndexOf(Type item);

    void remove(int index);

    List subList(int from, int to);
}
