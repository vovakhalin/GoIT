package Module12;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Date d = new Date();
                        System.out.println(d);
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(5000);
                        System.out.println("Минуло 5 секунд");
                    }
                } catch (Exception e) {
                }
            }
        }).start();
    }
}
