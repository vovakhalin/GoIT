package HomeworkTwo;

public class MyArrayList{
    private Object[] array;
    private int size;

    public MyArrayList() {
        array = new Object[10];
        size = 0;
    }

    public void add(Object value) {

        if (size == array.length) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Індекс виходить за межі списку");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;

    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Індекс виходить за межі списку");
        }
        return array[index];
    }

    public int getSize() {
        return size;
    }

    public void size() {
        System.out.println("size of array - " + getSize());
    }

    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    public void clear() {
        Object[] newClearArray = new Object[array.length];
        System.arraycopy(array, 0, newClearArray, 0, 0);
        array = newClearArray;
    }


}
