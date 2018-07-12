package ru.sbrf.collection.profi;

public interface Deque<Type> extends Collection<Type> {
    void addFirst(Type item);

    void addLast(Type item);

    Type getFirst();

    Type getLast();

    Type pollFirst();

    Type pollLast();

    Type removeFirst();

    Type removeLast();
}
