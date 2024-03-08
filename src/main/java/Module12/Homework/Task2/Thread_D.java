package Module12.Homework.Task2;

public class Thread_D extends Thread {
    private Resourse resourse;

    public Thread_D(Resourse resourse) {
        this.resourse = resourse;
    }

    @Override
    public void run() {
        while (true) {
            try {
                resourse.number();
                if (resourse.sharedResource.isEmpty()) {
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        if (resourse.lineFinale.size() == resourse.getN()) {
            String result = resourse.queueToString(resourse.lineFinale);
            System.out.println(result);
        }
    }
}
