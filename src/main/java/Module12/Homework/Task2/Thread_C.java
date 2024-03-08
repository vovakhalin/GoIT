package Module12.Homework.Task2;

public class Thread_C extends Thread{
    private Resourse resourse;

    public Thread_C(Resourse resourse) {
        this.resourse = resourse;
    }

    @Override
    public void run() {
        while (true) {
            try {
                resourse.fizzbuzz();
                if(resourse.sharedResource.isEmpty()){
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
