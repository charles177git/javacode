package chapater12.practise2;

import java.util.*;

import static java.lang.Thread.sleep;

/**
 *  Carpark is a class to similar only One space, will enter car queue and leave the car queue.
 */
public class Carpark {
    //carpark is available = true, if no empty then set flag = false;
    private boolean flag;
    private String name;
    public int CARCOUNT = 50;
    private List<Integer> lists;
    public Carpark(String name, Boolean carparkstatus) {
        this.name = name;
        this.flag = carparkstatus;
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
        //trail and experiment one time only can run one, the similar result.
        test.trail();
//        test.experiment();
    }

    /**
     * follow the book requirement define boolean to present carpark.
     */
    protected void trail() {
        Map<String, Boolean> carparknameandstatus = new HashMap<String, Boolean>();
        //first car park name and status.
        carparknameandstatus.put("Common", true);

        carparknameandstatus.put("Luxury", true);

        carparknameandstatus.put("Royal", true);
        Set<String> set;
        set = new  HashSet<String>();
        set = carparknameandstatus.keySet();
        for (String item : set) {
            Carpark carpark = new Carpark(item, carparknameandstatus.get(item));
            System.out.println("Car park name " + carpark.getCarparkName() + " place");

            WaitingQueue waitingQueue  = new WaitingQueue(carpark);
            waitingQueue.start();

            LeavingQueue leavingQueue = new LeavingQueue(carpark);
            leavingQueue.start();

        }

    }

    protected void experiment() {

        Map<String, Boolean> carparknameandstatus = new HashMap<String, Boolean>();
        //first car park name and status.
        carparknameandstatus.put("Common", true);

        carparknameandstatus.put("Luxury", true);

        carparknameandstatus.put("Royal", true);


        Carpark carpark = new Carpark("common", carparknameandstatus.get("Common"));
        System.out.println("Car park name " + carpark.getCarparkName() + " place");

        WaitingQueue waitingQueue = new WaitingQueue(carpark);
        waitingQueue.start();

        LeavingQueue leavingQueue = new LeavingQueue(carpark);
        leavingQueue.start();
        //second carpark.
        Carpark carparkOne = new Carpark("Luxury", carparknameandstatus.get("Luxury"));
        System.out.println("Car park name " + carpark.getCarparkName() + " place");

        WaitingQueue waitingQueueOne = new WaitingQueue(carparkOne);
        waitingQueueOne.start();

        LeavingQueue leavingQueueOne = new LeavingQueue(carparkOne);
        leavingQueueOne.start();
        //Third carpark
        Carpark carparkThird = new Carpark("Royal", carparknameandstatus.get("Royal"));
        System.out.println("Car park name " + carpark.getCarparkName() + " place");

        WaitingQueue waitingQueueThird = new WaitingQueue(carparkThird);
        waitingQueueThird.start();

        LeavingQueue leavingQueueThird = new LeavingQueue(carparkThird);
        leavingQueueThird.start();

    }

}

