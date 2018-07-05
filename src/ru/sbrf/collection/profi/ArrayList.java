package ru.sbrf.collection.profi;


public class ArrayList implements List  {
    private Object [] array;
    private Object [] arrayNew;
    private int size;

    public ArrayList () {
        array = new Object[10];
    }

    private ArrayList(Object[] array) {
        this.array = array;
    }



    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size==0);
    }

    @Override
    public boolean contains(Object item) {
        for (int i=0; i<size; i++) {
            if (array[i].equals(item))
                return true;
        }
        return false;
    }

    @Override
    public boolean add(Object item) {
        moreLength();
        array[size++]=item;
        return true;
    }

    @Override
    public boolean remove(Object item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear(){
        array = new Object[10];
    }

    @Override
    public void add(int index, Object item) {
        moreLength();
        for (int i=size-1; i>=index; i--) {
            array[i] = array [i+1];
        }
        array[index]=item;
        size++;
    }

    @Override
    public void set(int index, Object item) {
            if (index<size)
                array[index]=item;
    }


    @Override
    public Object get(int index) {
        if (index<size)
            return array[index];
        else
            throw new IndexOutOfBoundsException();
    }

    @Override
    public int indexOf(Object item) {
        for  (int i=0; i<size; i++) {
            if (array[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object item) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        for (int i=0; i<index; i++) {
            if (i==index)
                for (int j=i; j<size-1; j++)
                    array[j]=array[j+1];
            size--;
        }
    }

    @Override
    public List subList(int from, int to) {
        if (to <= size) {
            Object[] arrayNew = new Object[to - from];
            int j = 0;
            for (int i = from; i < to; i++) {
                arrayNew[j++] = array[i];
            }
            return new ArrayList(arrayNew);
        }
        throw new IndexOutOfBoundsException();
    }

    private void moreLength() {
        if (array.length == size) {
            Object[] arrayNew = new Object[size * 3 / 2 + 1];
            for (int i = 0; i < size; i++) {
                arrayNew[i] = array[i];
            }
            array = arrayNew;
        }
    }
}
