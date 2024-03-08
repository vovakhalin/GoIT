package Module12.Homework.Task2;

public class Thread_A extends Thread{
    private Resourse resourse;

    public Thread_A(Resourse resourse) {
        this.resourse = resourse;
    }

    @Override
    public void run() {
        while (true) {
            try {
                resourse.fizz();
                if(resourse.sharedResource.isEmpty()){
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
