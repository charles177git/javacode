package chapater12.practise;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        producerConsumer.test();
    }

    public void test() {
        BlockingQueue bq = new ArrayBlockingQueue(1);
        new Producer(bq, "Charles").start();
        new Producer(bq, "Xue Min").start();
        new Producer(bq, "Huazhen").start();
        new Consumer(bq, "Yingli").start();
    }
}

class Producer extends Thread {
    private BlockingQueue<String> bq;
    String[] books = new String[]{"Think in Java", "Spring Framework", "MadJava"};
    private String name;

    public Producer(BlockingQueue bq, String name) {
        this.bq = bq;
        this.name = name;
    }

    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ", " + name + " is ready to produce book");
                sleep(30);
                bq.put(books[i % 3]);
                System.out.println(Thread.currentThread().getName() + ", " + name + " published " + bq + " book");
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}


class Consumer extends Thread {
    private BlockingQueue<String> bq;
    private String name;

    public Consumer(BlockingQueue<String> bq, String name) {
        this.bq = bq;
        this.name = name;
    }

    public void run() {
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ", " + name + " is ready to buy book");
                sleep(30);
                String book = this.bq.take();
                System.out.println(Thread.currentThread().getName() + "," + name + " purchased " + bq + " book");
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}

