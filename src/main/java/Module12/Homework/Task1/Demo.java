package Module12.Homework.Task1;

import java.util.Date;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            long currentDate = System.currentTimeMillis() - 1000;
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) { //цикл зробив, щоб зупинитись через 20с.
                    try {
                        long d = System.currentTimeMillis();
                            System.out.println((d - currentDate)/1000);
                            Thread.sleep(1000);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }}
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 4; i++) {
                    try {
                        Thread.sleep(5000);
                        System.out.println("Минуло 5 секунд");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }}
        }).start();

        Thread.sleep(3000);
        Thread.interrupted();



    }
}
