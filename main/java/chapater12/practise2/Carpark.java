package chapater12.practise2;

import java.util.List;

import static java.lang.Thread.sleep;

/**
 *  Carpark is a class to similar only one space, will enter car queue and leave the car queue.
 */
public class Carpark {
    //carpark is available = true, if no empty then set flag = false;
    private boolean flag = true;
    private String name;

    public Carpark(String name) {
        this.name = name;
    }
    protected String getCarparkName() {
        return this.name;
    }

    //cars enter the carpark position
    protected synchronized void driveIn(String plate) {
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
    protected synchronized void driveOut(String plate) {
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
        for (int i= 1; i <= 50; i++) {
            plate = carpark.generatePlate(i);
            carpark.driveIn(plate);
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
        for (int j = 1; j<= 50; j++) {
            plate = this.carpark.generatePlate(j);
            carpark.driveOut(plate);
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
    }
}
