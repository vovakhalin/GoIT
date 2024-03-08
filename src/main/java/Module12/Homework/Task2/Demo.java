package Module12.Homework.Task2;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Resourse result = new Resourse(31);
        Thread_D threadD = new Thread_D(result);
        Thread_A threadA = new Thread_A(result);
        Thread_B threadB = new Thread_B(result);
        Thread_C threadC = new Thread_C(result);

        result.create();

        threadD.start();
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
