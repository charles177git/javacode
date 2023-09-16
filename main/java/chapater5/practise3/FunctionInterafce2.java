package chapater5.practise3;

import static java.lang.Thread.sleep;

public class FunctionInterafce2 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 30; i++) {
                System.out.println("i =  " + i);
                try {
                    sleep(1000);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        };

        Thread myThread = new Thread(runnable);
        myThread.start();

        for (int j = 0; j < 30; j++) {
            System.out.println(Thread.currentThread().getId() + ", name " + Thread.currentThread().getName() + ", j = " + j);
            try {
                sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
