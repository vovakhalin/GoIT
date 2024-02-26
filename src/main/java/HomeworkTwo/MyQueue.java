package HomeworkTwo;

public class MyQueue <T>{
    private Object[] array;
    private int size;

    public MyQueue() {
        array = new Object[10];
        size = 0;
    }

    public void add(Object value) {

        if (size == array.length) {
            Object[] newArray = new Object[size];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size] = value;
        size++;
    }

    public int size() {
        return size;
    }

    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    public T peek() {
        return (T) array[0];
    }

    public T pool() {
        Object result = array[0];
        Object[] newArray = new Object[size];
        System.arraycopy(array, 1, newArray, 0, size);
        array = newArray;
        size--;
        return (T) result;
    }

    public void clear() {
        Object[] newClearArray = new Object[size];
        System.arraycopy(array, 0, newClearArray, 0, 0);
        array = newClearArray;
    }
}
