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
    public void addFirst(Object item) { //made before - work
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
    public void addLast(Object item) { //made before - work
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
    public Object getFirst() { //made before - work
        checkForExisting(0);
        return first.item;
    }

    @Override
    public Object getLast() { //made before - work
        checkForExisting(0);
        return last.item;
    }

    @Override
    public Object pollFirst() { //made before - work
        try {
            return removeFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public Object pollLast() { //made before - work
        try {
            return removeLast();
        } catch (NoSuchElementException e) {
            return null;
        }
    }


    @Override
    public Object removeFirst() { //made before - work
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
    public Object removeLast() { //made before - work
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
    public void add(int index, Object item) { //made - work
        checkForExisting(index);

        checkForNodeIndex(index, item);

        Node newNode = new Node();
        newNode.item=item;
        Node current = getNode(index);
        current.next = current;
        current.prev = newNode;
        size ++;
    }

    @Override
    public void set(int index, Object item) {//made - work
        checkForExisting(index);
        getNode(index).item = item;
    }

    @Override
    public Object get(int index) { //made before - work
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
    public int indexOf(Object item) {//made before - work
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
    public int lastIndexOf(Object item) { //made - work
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
    public List subList(int from, int to) {//made
        checkForRange(to, from);
        LinkedList result = new LinkedList();
        result.addFirst(get(from));
        for (int i = from+1; i < to; i++) {
            result.addLast(get(i));
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
    public boolean contains(Object item) { //made - work
        Node current = first;
        for (int i = 0; i < size; i++) {
            if (current.item.equals(item)) {
                return true;
            }
            current=current.next;
        }
        return false;
    }


    @Override
    public boolean add(Object item) { //made - work
        addLast(item);
        return true;
    }

    @Override
    public boolean remove(Object item) { //made - work
        if (indexOf(item)==-1)
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
        if (index==0)
            addFirst(item);
        if (index==size-1)
            addLast(item);
    }

    private void removeNode (Node node) {
        if (node.prev == null) {
            first = node.next;
            first.prev=null;
            size--;
        }
        else if (node.next == null) {
            last = node.prev;
            last.next=null;
            size--;
        } else {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;
        }
    }

}