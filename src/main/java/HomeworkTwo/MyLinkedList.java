package HomeworkTwo;

import java.util.Objects;

public class MyLinkedList <T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {
        Node<T> node = new Node<>(value);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        size++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public int getSize() {
        return size;
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> previous;

        public Node(T value) {
            this.value = value;
        }
    }

    public void show() {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + "-й елемент - " +current.value);
            current = current.next;
        }
    }

    public void size() {
        System.out.println("Size of List - " + getSize());
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Індекс виходить за межі списку");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (current.previous != null) {
            current.previous.next = current.next;
        } else {
            head = current.next;
        }
        if (current.next != null) {
            current.next.previous = current.previous;
        } else {
            tail = current.previous;
        }
        size--;
    }
}
