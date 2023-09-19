package chapater12.practise;

import java.util.concurrent.FutureTask;
import java.util.concurrent.Callable;

public class FutureWithCallable {
    public static void main(String[] args) {
        FutureWithCallable futureWithCallable = new FutureWithCallable();
        futureWithCallable.test();
    }
    protected void test() {
        FutureTask<Integer> futureTask = new FutureTask<Integer>((Callable<Integer>)() -> {
            int j = 0;
            for (; j < 100; j++) {
                System.out.println(Thread.currentThread().getName() + ", j = " + j);
            }
            return j;
        });

        for (int i =0 ; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ", i = " +i);
            if (i == 20 ) {
                new Thread(futureTask, "Thread-1").start();
            }
        }
        try {
            System.out.println(futureTask.get());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}