package chapater12.practise;

public class ThreadRuntime implements Runnable {
    public static void main(String[] args) {
        ThreadRuntime threadRuntime = new ThreadRuntime();
        threadRuntime.test();
    }

    @Override
    public void run() {
        for (int i=0; i< 100; i++) {
            System.out.println("Thread " + Thread.currentThread().getName() + ", i = " + i );
        }
    }

    protected  void test() {
        for (int i =0; i < 100; i++) {
            if (i ==20) {
                ThreadRuntime threadRuntimeOther = new ThreadRuntime();
                new Thread(threadRuntimeOther, "Thread-1").start();
                new Thread(threadRuntimeOther, "Thread-2").start();

            }
            System.out.println("Thread " + Thread.currentThread().getName() + ", i = " + i);
        }

    }
}
