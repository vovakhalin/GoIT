package Module12.Lesson;

public class Consumer extends Thread{
    private Resource2 resource;

    public Consumer(Resource2 resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                resource.consume();
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
