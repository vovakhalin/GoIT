package Module12;

import java.util.LinkedList;
import java.util.Queue;

public class Number {
    private Queue<Integer> numbers = new LinkedList<>();
    private int n;

    public Number(int n) {
        this.n = n;
    }

    Queue<String> stringThreads = new LinkedList<>();

    public synchronized void fizz() throws InterruptedException {
        while (numbers.peek() % 3 != 0) {
            wait();
        }
        stringThreads.add("fizz");
        notify();
    }

    public synchronized void numbers(int n) throws InterruptedException {
        for (int i = 1; i <= n; n++) {
            while (i % 3 == 0) {
                wait();
            }
            stringThreads.add(Integer.toString(i));
            notify();
        }
    }
}
