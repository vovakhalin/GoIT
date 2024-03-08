package Module12.Homework.Task2;

public class Thread_B extends Thread{
    private Resourse resourse;

    public Thread_B(Resourse resourse) {
        this.resourse = resourse;
    }

    @Override
    public void run() {
        while (true) {
            try {
                resourse.buzz();
                if(resourse.sharedResource.isEmpty()){
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
