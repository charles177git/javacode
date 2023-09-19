package chapater12.practise;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockSaveTake {
    public static void main(String[] args) {
        SaveTake saveTake = new SaveTake();
        saveTake.test();
    }

    protected void test() {
        MyBankAccount myBankAccount = new MyBankAccount("007", 0 );
        TakeBankMoney takeMoney = new TakeBankMoney("Huazhen", myBankAccount, 800);
        new Thread(takeMoney).start();

        SaveBankMoney saveMoney2 = new SaveBankMoney("Min Xue", myBankAccount, 800);
        new Thread(saveMoney2).start();

        SaveBankMoney saveMoney = new SaveBankMoney("Charles", myBankAccount, 800);
        new Thread(saveMoney).start();

    }

}


class MyBankAccount {
    private String account;
    private double balance;
    private boolean flag = false; //flage = false mean no money.
    Lock reentrantLock;
    Condition condition;
    public MyBankAccount(String account, double balance) {
        this.account = account;
        this.balance = balance;
        reentrantLock = new ReentrantLock();
        condition = reentrantLock.newCondition();
    }

    protected  void save(double money, String person) {
        reentrantLock.lock();
        try {
            if (flag) {
                condition.await();
            } else {
                this.balance += money;
                System.out.println(person + " saves " + money + ", balance is " + this.balance);
                flag = true;
                condition.signalAll();
            }

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }

    protected void take(double money, String person) {
        reentrantLock.lock();
        try {
            if (!flag) {
                condition.await();
            } else {
                this.balance -= money;
                System.out.println(person +  " takes " + money + ", balance is " + this.balance);
                flag = false;
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            reentrantLock.unlock();
        }
    }
}

class TakeBankMoney extends Thread {
    private MyBankAccount account;
    private String name;
    private double money;
    public TakeBankMoney(String name, MyBankAccount account, double money) {
        this.account = account;
        this.name  = name;
        this.money = money;
    }

    public void run() {
        for (int i =0 ; i < 100 ; i++) {
            account.take(money, this.name);
        }
    }
}


class SaveBankMoney extends Thread {
    private MyBankAccount account;
    private String name;
    private double money;
    public SaveBankMoney(String name, MyBankAccount account, double money) {
        this.account = account;
        this.name  = name;
        this.money = money;
    }

    public void run() {
        for (int i =0 ; i < 100 ; i++) {
            account.save(money, this.name);
        }
    }
}