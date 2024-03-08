package Module12.Lesson;

public class Producer extends Thread {
    private Resource2 resource;

    public Producer(Resource2 resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        int item = 0;
        while (true) {
            try {
                resource.produce(item++);
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
