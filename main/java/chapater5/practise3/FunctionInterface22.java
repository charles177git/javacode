package chapater5.practise3;

import static java.lang.Thread.sleep;
import java.lang.InterruptedException;

public class FunctionInterface22 {
    public static void main(String[] args) {

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                for (int i =0; i< 30; i++) {
//                    System.out.println("i = " + i );
//                    try {
//                        sleep(1000);
//                    }catch (InterruptedException ie) {
//                        ie.printStackTrace();
//                    }
//                }
//            }
//        };
        Runnable runnable = () -> {
            for (int k=0; k < 30 ; k++) {
                System.out.println("k = " + k);
                try {
                    sleep(1000);
                }catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        //main thread
        try {
            for (int j = 0; j < 30; j++) {
                System.out.println(Thread.currentThread().getId() + ", name " + Thread.currentThread().getName() + ", J = " + j);
                sleep(1000);
            }
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        }

    }
}
