package ru.sbrf.collection.profi;


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
        return first;
    }

    @Override
    public Object getLast() {
        checkForExisting(0);
        return last;
    }

    @Override
    public Object pollFirst() {
        //checkForExisting(0);


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
    public Object pollLast() {
        //checkForExisting(0);

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

    }

    @Override
    public void set(int Index, Object item) {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object item) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object item) {
        return 0;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public List subList(int from, int to) {
        return null;
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
    public boolean contains(Object item) {
        return false;
    }

    @Override
    public boolean add(Object item) {
        return false;
    }

    @Override
    public boolean remove(Object item) {

        return false;
    }

    @Override
    public void clear() {
        Node node = new Node();
    }


    private void checkForExisting(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}