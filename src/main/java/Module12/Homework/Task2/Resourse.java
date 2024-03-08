package Module12.Homework.Task2;

import java.util.LinkedList;
import java.util.Queue;

public class Resourse {
    public Queue<Integer> sharedResource = new LinkedList<>();
    public Queue<String> line = new LinkedList<>();
    private final int n;

    public int getN() {
        return n;
    }

    public Resourse(int n) {
        this.n = n;
    }

    public void create(){
        for (int i = 1; i <= n; i++) {
            sharedResource.add(i);
        }
    }
    public synchronized void number() throws InterruptedException {
        while(!sharedResource.isEmpty() && (sharedResource.peek() % 3 == 0 || sharedResource.peek() % 5 == 0)) {
            wait();
        }
        if(!sharedResource.isEmpty()) {
            Integer item = sharedResource.remove();
            line.add(Integer.toString(item));
//            System.out.println("number : " + item);
            notifyAll();
        }
    }
    public synchronized void fizz() throws InterruptedException {
        while(!sharedResource.isEmpty() && sharedResource.peek() % 3 != 0) {
            wait();
        }
        if(!sharedResource.isEmpty() && sharedResource.peek() % 5 != 0) {
            Integer item = sharedResource.remove();
            line.add("fizz");
//            System.out.println("fizz : " + item);
            notifyAll();
        }
    }
    public synchronized void buzz() throws InterruptedException {
        while(!sharedResource.isEmpty() && (sharedResource.peek() % 5 != 0 && sharedResource.peek() % 15 != 0)) {
            wait();
        }
        if(!sharedResource.isEmpty() && sharedResource.peek() % 15 != 0) {
            Integer item = sharedResource.remove();
            line.add("buzz");
//            System.out.println("buzz : " + item);
            notifyAll();
        }
    }
    public synchronized void fizzbuzz() throws InterruptedException {
        while(!sharedResource.isEmpty() && sharedResource.peek() % 15 != 0) {
            wait();
        }
        if(!sharedResource.isEmpty()) {
            Integer item = sharedResource.remove();
            line.add("fizzbuzz");
//            System.out.println("fizzbuzz : " + item);
            notifyAll();
        }
    }
    public String queueToString(Queue<String> queue) {
        return String.join(", ", queue);
    }
}

