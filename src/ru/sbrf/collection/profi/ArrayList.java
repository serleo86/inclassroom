package ru.sbrf.collection.profi;


@SuppressWarnings("unchecked")
public class ArrayList<Type> implements List<Type> {
    private Type[] array;
    private int size;

    public ArrayList() {
        this(10);
    }

    private ArrayList(int capacity) {
        initialize(capacity);
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
        extendArrayAsNeeded();
        array[size++] = item;
        return true;
    }

    @Override
    public boolean remove(Type item) {
        int index = indexOf(item);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        initialize(10);
    }

    private void initialize(int capacity) {
        array = (Type[]) new Object[capacity];
        size = 0;
    }

    @Override
    public void add(int index, Type item) {
        extendArrayAsNeeded();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
    }

    @Override
    public void set(int index, Type item) {
        checkForRange(index);
        array[index] = item;
    }


    @Override
    public Object get(int index) {
        checkForRange(index);
        return array[index];
    }

    @Override
    public int indexOf(Type item) {
        if (item == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (item.equals(array[i]))
                    return i;
            }
        }
        return -1;
    }

    @Override
    // ToDo:
    public int lastIndexOf(Type item) {
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
        List<Type> result = new ArrayList<>(to - from);
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
            Type[] arrayNew = (Type[]) new Object[size * 3 / 2 + 1];
            for (int i = 0; i < size; i++) {
                arrayNew[i] = array[i];
            }
            array = arrayNew;
        }
    }
}
