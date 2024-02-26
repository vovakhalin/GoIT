package HomeworkTwo;

public class Demo {
    public static void main(String[] args) {

//        MyArrayList stringArrayList = new MyArrayList();
//        MyArrayList integerArrayList = new MyArrayList();
//        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
//
//        stringArrayList.add("Hello ");
//        stringArrayList.add("My ");
//        stringArrayList.add("World");
//        stringArrayList.add("!");
//
//        integerArrayList.add(1);
//        integerArrayList.add(2);
//        integerArrayList.add(3);
//        integerArrayList.add(4);
//        integerArrayList.add(5);
//        integerArrayList.add(6);
//        integerArrayList.add(7);
//
//        stringArrayList.show();
//        integerArrayList.show();
//
//        stringArrayList.clear();
//        System.out.println("----clear----");
//        stringArrayList.show();
//
//        stringArrayList.size();
//
//        System.out.println("index - " + integerArrayList.get(2));
//
//        integerArrayList.remove(2);
//        System.out.println("----remove----");
//        integerArrayList.show();
//
//        myLinkedList.add(2);
//        myLinkedList.add(34);
//        myLinkedList.add(24);
//        myLinkedList.add(22);
//        myLinkedList.add(65);
//
//        myLinkedList.show();
//        myLinkedList.size();
////      myLinkedList.clear();
//
//        myLinkedList.remove(3);
//        myLinkedList.show();

//        MyQueue <Integer> myQueue = new MyQueue<>();
//
//        myQueue.add(5);
//        myQueue.add(10);
//        myQueue.add(12);
//        myQueue.add(34);
//        myQueue.add(67);
//
//        myQueue.show();
//
//        System.out.println("size - " + myQueue.size());
//
//        System.out.println("first element - " + myQueue.peek());
//
//        System.out.println("pool result - " + myQueue.pool());
//        myQueue.show();
//        System.out.println("pool result - " + myQueue.pool());
//        myQueue.show();
//
//        myQueue.clear();
//        myQueue.show();

//        MyStack<Integer> stackOne = new MyStack<>();
//        stackOne.push(10);
//        System.out.println(stackOne.peek());
//        stackOne.push(20);
//        System.out.println(stackOne.peek());

        MyHashMap<Integer, String> mapOne = new MyHashMap<>();

        mapOne.put(2, "Hello");
        System.out.println(mapOne.size());
        System.out.println(mapOne.get(2));
        mapOne.clear();
        System.out.println(mapOne.size());


    }
}
