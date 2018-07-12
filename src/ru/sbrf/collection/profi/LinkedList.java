package ru.sbrf.collection.profi;


import java.util.NoSuchElementException;

public class LinkedList implements List, Deque {
    private static class Node {
        private Node prev;
        private Node next;
        private Object item;
    }

    private Node first;
    private Node last;
    private int size;

    @Override
    public void addFirst(Object item) {
        Node newNode = new Node();
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
    public void addLast(Object item) {
        Node newNode = new Node();
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
    public Object getFirst() {
        checkForExisting(0);
        return first.item;
    }

    @Override
    public Object getLast() {
        checkForExisting(0);
        return last.item;
    }

    @Override
    public Object pollFirst() {
        try {
            return removeFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public Object pollLast() {
        try {
            return removeLast();
        } catch (NoSuchElementException e) {
            return null;
        }
    }


    @Override
    public Object removeFirst() {
        checkForExisting(0);

        Object result = first.item;

        first = first.next;
        if (first != null) {
            first.prev = null;
        } else {
            last = null;
        }
        size--;

        return result;

    }

    @Override
    public Object removeLast() {
        checkForExisting(0);

        Object result = last.item;

        last = last.prev;
        if (last != null) {
            last.next = null;
        } else {
            first = null;
        }
        size--;

        return result;
    }


    @Override
    public void add(int index, Object item) {
        checkForExisting(index);

        checkForNodeIndex(index, item);

        Node newNode = new Node();
        newNode.item = item;
        Node current = getNode(index);
        current.next = current;
        current.prev = newNode;
        size++;
    }

    @Override
    public void set(int index, Object item) {
        checkForExisting(index);
        getNode(index).item = item;
    }

    @Override
    public Object get(int index) {
        checkForExisting(index);
        return getNode(index).item;

    }

    private Node getNode(int index) {
        if (index < size / 2) {
            return getNodeFromLeft(index);
        } else {
            return getNodeFromRight(index);
        }
    }

    private Node getNodeFromLeft(int index) {
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private Node getNodeFromRight(int index) {
        Node current = last;
        for (int i = size - 1; i >= index; i--) {
            current = current.prev;
        }
        return current.next;
    }

    @Override
    public int indexOf(Object item) {
        Node current = first;
        for (int i = 0; i < size; i++) {
            if (current.item.equals(item)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object item) {
        Node current = last;
        for (int i = size - 1; i >= 0; i--) {
            if (current.item.equals(item)) {
                return i;
            } else {
                current = current.prev;
            }
        }
        return -1;
    }

    @Override
    public void remove(int index) {//made - work
        removeNode(getNode(index));
    }


    @Override
    public List subList(int from, int to) {
        checkForRange(to, from);
        LinkedList result = new LinkedList();
        for (int i = from; i < to; i++) {
            result.add(get(i));
        }
        return result;

    }

    @Override
    public int size() { //work
        return size;
    }


    @Override
    public boolean isEmpty() { //work
        return (size == 0);
    }

    @Override
    public boolean contains(Object item) {
        Node current = first;
        for (int i = 0; i < size; i++) {
            if (current.item.equals(item)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    @Override
    public boolean add(Object item) {
        addLast(item);
        return true;
    }

    @Override
    public boolean remove(Object item) {
        if (indexOf(item) == -1)
            return false;
        else {
            remove(indexOf(item));
        }
        return true;
    }

    @Override
    public void clear() { //ГОТОВО
        Node node = new Node();
    }

    private void checkForExisting(int index) {
        if (index >= size) {
            throw new NoSuchElementException();
        }
    }

    private void checkForRange(int to, int from) {
        if (from > to) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkForNodeIndex(int index, Object item) {
        if (index == 0)
            addFirst(item);
        if (index == size - 1)
            addLast(item);
    }

    private void removeNode(Node removingNode) {
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
    }

}