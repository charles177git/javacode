package chapater12.practise2;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 *  Carpark is a class to similar only One space, will enter car queue and leave the car queue.
 */
public class Carpark {
    //carpark is available = true, if no empty then set flag = false;
    private boolean flag = true;
    private String name;
    public int CARCOUNT = 50;
    private List<Integer> lists;
    public Carpark(String name) {
        this.name = name;
        lists = new ArrayList<Integer>();
        //because thread shard the memory, leave queue and enter quenu access the same list, should every element duplicate.
        for (int i = 1; i<= CARCOUNT; i++) {
            lists.add(i);
            lists.add(i);
        }
    }
    protected String getCarparkName() {
        return this.name;
    }

    //cars enter the carpark position
    protected synchronized void driveIn(int i) {
        int k = lists.get(i - 1);
        String plate = generatePlate(k);
        try {
            if (!flag) {
                wait();
            } else {
                System.out.println("Car plate " + plate + " is entering the " + this.name + " carpark, fill in electricity or petrol, enjoying a short break");
                flag = false; //the car is filling, so no space, flag = false;
                notifyAll();
            }
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
            ie.printStackTrace();
        }
    }

    //cars leave  carpark position.
    protected synchronized void driveOut(int i) {
        int k = lists.get(i-1);
        String plate = generatePlate(k);
        try {
            if (flag) {
                wait();
            } else {
                //car park can not use for others, so the car is leaving now, give the space to other people.
                System.out.println("Car plate " + plate + " is leaving the "+ this.name + " carpark, delivery the place to next car");
                flag = true;
                notifyAll();
            }
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
            ie.printStackTrace();
        }

    }

    protected String generatePlate(int number) {
        String no = String.valueOf(number);
        String plate="";
        switch (no.length()) {
            case 1:
                plate =  "P00" + no;
                break;
            case 2:
                plate =  "P0" + no;
                break;
            default:
                plate =  "P" + no;
                break;
        }
        return plate;
    }


}

class WaitingQueue extends Thread {
    private Carpark carpark;

    public WaitingQueue(Carpark carpark) {
        this.carpark = carpark;
    }

    public void run() {
        String plate;
        for (int i= 1; i <= this.carpark.CARCOUNT; i++) {
            carpark.driveIn(i);
        }
    }
}

class LeavingQueue extends Thread {
    private Carpark carpark;
    public LeavingQueue(Carpark carpark) {
        this.carpark = carpark;
    }

    public void run() {
        String plate;
        for (int j = 1; j<= this.carpark.CARCOUNT; j++) {
            carpark.driveOut(j);
        }
    }
}

class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.trail();
    }

    protected void trail() {
        Carpark carpark = new Carpark("common");
        System.out.println("Car park name " + carpark.getCarparkName() + " place");

        WaitingQueue waitingQueue = new WaitingQueue(carpark);
        waitingQueue.start();

        LeavingQueue leavingQueue = new LeavingQueue(carpark);
        leavingQueue.start();
        //second carpark.
        Carpark carparkOne = new Carpark("luxury");
        System.out.println("Car park name " + carpark.getCarparkName() + " place");

        WaitingQueue waitingQueueOne = new WaitingQueue(carparkOne);
        waitingQueueOne.start();

        LeavingQueue leavingQueueOne = new LeavingQueue(carparkOne);
        leavingQueueOne.start();
        //Third carpark
        Carpark carparkThird = new Carpark("Royal");
        System.out.println("Car park name " + carpark.getCarparkName() + " place");

        WaitingQueue waitingQueueThird = new WaitingQueue(carparkThird);
        waitingQueueThird.start();

        LeavingQueue leavingQueueThird = new LeavingQueue(carparkThird);
        leavingQueueThird.start();
    }

}
