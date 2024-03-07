package Module12;

import java.util.LinkedList;
import java.util.Queue;

public class FizzBuzz {
    private final int n;
    private final Queue<String> queue;

    public FizzBuzz(int n) {
        this.n = n;
        this.queue = new LinkedList<>();
    }




    public synchronized void number() {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                queue.offer("fizzbuzz");
            } else if (i % 3 == 0) {
                queue.offer("fizz");
            } else if (i % 5 == 0) {
                queue.offer("buzz");
            } else {
                queue.offer(Integer.toString(i));
            }
        }
    }

    public static void main(String[] args) {
        int n = 15;
        FizzBuzz fizzBuzz = new FizzBuzz(n);

        Thread threadD = new Thread(fizzBuzz::number);


        threadD.start();

        try {

            threadD.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        StringBuilder result = new StringBuilder();
        while (!fizzBuzz.queue.isEmpty()) {
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(fizzBuzz.queue.poll());
        }

        System.out.println(result.toString());
    }
}