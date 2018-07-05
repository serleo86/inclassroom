package ru.sbrf.collection.profi;


public class ArrayList implements List {
    private Object[] array;
    private int size;

    public ArrayList() {
        initialize();
    }

    private ArrayList(int size) {
        this.array = new Object[size];
        this.size = size;
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
        return indexOf(item) != -1;
    }

    @Override
    public boolean add(Object item) {
        extendArrayAsNeeded();
        array[size++] = item;
        return true;
    }

    @Override
    public boolean remove(Object item) {
        int index = indexOf(item);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        initialize();
    }

    private void initialize() {
        array = new Object[10];
        size = 0;
    }

    @Override
    public void add(int index, Object item) {
        extendArrayAsNeeded();
        for (int i = size - 1; i >= index; i--) {
            array[i] = array[i + 1];
        }
        array[index] = item;
        size++;
    }

    @Override
    public void set(int index, Object item) {
        checkForRange(index);
        array[index] = item;
    }


    @Override
    public Object get(int index) {
        checkForRange(index);
        return array[index];
    }

    @Override
    public int indexOf(Object item) {
        for (int i = 0; i < size; i++) {
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
        checkForRange(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
    }

    private void checkForRange(int index) {
        if ((index < 0) || (index > size)) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public List subList(int from, int to) {
        checkForRange(to, from);
        List result = new ArrayList(to - from);
        for (int i = from; i < to; i++) {
            result.add(array[i]);
        }
        return result;
    }

    private void checkForRange(int to, int from) {
        if (from > to) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void extendArrayAsNeeded() {
        if (array.length == size) {
            Object[] arrayNew = new Object[size * 3 / 2 + 1];
            for (int i = 0; i < size; i++) {
                arrayNew[i] = array[i];
            }
            array = arrayNew;
        }
    }
}
