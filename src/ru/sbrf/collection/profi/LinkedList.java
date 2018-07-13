package ru.sbrf.collection.profi;


import java.util.NoSuchElementException;

public class LinkedList<Type> implements List<Type>, Deque<Type> {
    private static class Node<Type> {
        private Node<Type> prev;
        private Node<Type> next;
        private Type item;
    }

    private Node<Type> first;
    private Node<Type> last;
    private int size;

    @Override
    public void addFirst(Type item) {
        Node<Type> newNode = new Node<>();
        newNode.item = item;
        newNode.next = first;
        if (first != null) {
            first.prev = newNode;
        } else {
            last = newNode;
        }
        first = newNode;
        size++;
    }

    @Override
    public void addLast(Type item) {
        Node<Type> newNode = new Node<>();
        newNode.item = item;
        newNode.prev = last;
        if (last != null) {
            last.next = newNode;
        } else {
            first = newNode;
        }
        last = newNode;
        size++;
    }

    @Override
    public Type getFirst() {
        checkForNotEmpty();
        return first.item;
    }

    @Override
    public Type getLast() {
        checkForNotEmpty();
        return last.item;
    }

    @Override
    public Type pollFirst() {
        try {
            return removeFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public Type pollLast() {
        try {
            return removeLast();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public Type removeFirst() {
        checkForNotEmpty();
        return removeNode(first);

    }

    @Override
    public Type removeLast() {
        checkForNotEmpty();
        return removeNode(last);
    }

    @Override
    public void add(int index, Type item) {
        checkForRange(index);

        Node<Type> next = getNode(index);
        Node<Type> prev = (next != null) ? next.prev : null;

        Node<Type> newNode = new Node<>();
        newNode.item = item;
        newNode.next = next;
        newNode.prev = prev;

        if (prev != null) {
            prev.next = newNode;
        } else {
            first = newNode;
        }

        if (next != null) {
            next.prev = newNode;
        } else {
            last = newNode;
        }

        size++;
    }

    @Override
    public void set(int index, Type item) {
        checkForRange(index);
        getNode(index).item = item;
    }

    @Override
    public Type get(int index) {
        checkForRange(index);
        return getNode(index).item;

    }

    private Node<Type> getNode(int index) {
        if (index < size / 2) {
            return getNodeFromLeft(index);
        } else {
            return getNodeFromRight(index);
        }
    }

    private Node<Type> getNodeFromLeft(int index) {
        Node<Type> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private Node<Type> getNodeFromRight(int index) {
        Node<Type> current = last;
        for (int i = size - 1; i >= index; i--) {
            current = current.prev;
        }
        return current.next;
    }

    @Override
    // ToDo: учет null
    public int indexOf(Type item) {
        Node current = first;

        if (current.item == null) {
            for (int i = 0; i < size; i++) {
                if (item == null)
                    return i;
                else
                    current = current.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (item.equals(current.item)) {
                    return i;
                }
                current = current.next;
            }
        }
        return -1;
    }

    @Override
    // ToDo:
    public int lastIndexOf(Type item) {
        Node current = last;

        if (current.item == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (item==null)
                    return i;
                else
                    current = current.next;
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (item.equals(current.item))
                    return i;
                else {
                    current = current.prev;
                    }
                }
            }
        return -1;
        }



    @Override
    public void remove(int index) {
        checkForRange(index);
        removeNode(getNode(index));
    }

    @Override
    public List subList(int from, int to) {
        checkForRange(to, from);
        List<Type> result = new LinkedList<>();
        for (int i = from; i < to; i++) {
            result.add(get(i));
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Type item) {
        return indexOf(item) != -1;
    }

    @Override
    public boolean add(Type item) {
        addLast(item);
        return true;
    }

    @Override
    public boolean remove(Type item) {
        if (indexOf(item) == -1)
            return false;
        else {
            remove(indexOf(item));
            return true;
        }
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    private void checkForNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    private void checkForRange(int index) {
        if (index >= size) {
            throw new NoSuchElementException();
        }
    }

    private void checkForRange(int to, int from) {
        if (from > to) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Type removeNode(Node<Type> removingNode) {
        Type result = removingNode.item;

        if (removingNode.prev != null) {
            removingNode.prev.next = removingNode.next;
        } else {
            first = removingNode.next;
        }

        if (removingNode.next != null) {
            removingNode.next.prev = removingNode.prev;
        } else {
            last = removingNode.prev;
        }

        size--;

        return result;
    }

}