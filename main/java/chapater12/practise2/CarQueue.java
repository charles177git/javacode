package chapater12.practise2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CarQueue {
    public static void main(String[] args) {
        CarQueue carQueue = new CarQueue();
        carQueue.test();

    }

    public void test() {
        //define 3 carpark, each carpark only can stay one car one time.
        BlockingQueue[] bq = new BlockingQueue[3];
        bq[0] = new ArrayBlockingQueue<String>(1);
        bq[1] = new ArrayBlockingQueue<String>(1);
        bq[2] = new ArrayBlockingQueue<String>(1);

        new CarEnterQueue(bq).start();
        new CarQuitQueue(bq).start();
    }
}

//producer
class CarEnterQueue extends Thread {
    private BlockingQueue[] carpark;

    public CarEnterQueue(BlockingQueue[] carpark) {
        this.carpark = carpark;
    }

    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ", is ready to enter the carpark A");
                sleep(200);
                carpark[0].put(String.valueOf(i));
                System.out.println("No. " + i + " car enter carpark A to fill electricity or petrol and take a short break");
            }
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ", is ready to enter the carpark A");
                sleep(200);
                carpark[1].put(String.valueOf(i));
                System.out.println("No. " + i + " car enter carpark B to fill electricity or petrol and take a short break");
            }
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ", is ready to enter the carpark A");
                sleep(200);
                carpark[2].put(String.valueOf(i));
                System.out.println("No. " + i + " car enter carpark C to fill electricity or petrol and take a short break");
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}

//consumer
class CarQuitQueue extends Thread {
    private BlockingQueue<String>[] carpark;

    public CarQuitQueue(BlockingQueue<String>[] carpark) {
        this.carpark = carpark;
    }

    public void run() {
        try {
            while (true) {
                System.out.println("After cars finish fill petrol or fill electricity, it is ready to quite the queue");
                sleep(200);
                String carno = carpark[0].take();
                System.out.println("car " + carno + "is driving away");

//            while (true) {
                System.out.println("After cars finish fill petrol or fill electricity, it is ready to quite the queue");
                sleep(200);
                String carno1 = carpark[1].take();
                System.out.println("car " + carno1 + "is driving away");
//            }

//            while (true) {
                System.out.println("After cars finish fill petrol or fill electricity, it is ready to quite the queue");
                sleep(200);
                String carno2 = carpark[2].take();
                System.out.println("car " + carno2 + "is driving away");
//            }
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }
}