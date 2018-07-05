package ru.sbrf.collection.profi;

public interface List extends Collection {
    void add(int Index, Object item);

    void set(int Index, Object item);

    Object get(int index);

    int indexOf(Object item);

    int lastIndexOf(Object item);

    void remove(int index);

    List subList(int from, int to);
}
