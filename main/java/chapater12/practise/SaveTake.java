package chapater12.practise;


class MyAccount {
    private String account;
    private double balance;
    private boolean flag = false; //flage = false mean no money.

    public MyAccount(String account, double balance) {
        this.account = account;
        this.balance = balance;
    }

    protected synchronized void save(double money, String person) {
        try {
            if (flag) {
                wait();
            } else {
                this.balance += money;
                System.out.println(person + " saves " + money + ", balance is " + this.balance);
                flag = true;
                notifyAll();
            }

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }

    protected synchronized void take(double money, String person) {
        try {
            if (!flag) {
                wait();
            } else {
                this.balance -= money;
                System.out.println(person +  " takes " + money + ", balance is " + this.balance);
                flag = false;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class TakeMoney extends Thread {
    private MyAccount account;
    private String name;
    private double money;
    public TakeMoney(String name, MyAccount account, double money) {
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


class SaveMoney extends Thread {
    private MyAccount account;
    private String name;
    private double money;
    public SaveMoney(String name, MyAccount account, double money) {
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
public class SaveTake {
    public static void main(String[] args) {
        SaveTake saveTake = new SaveTake();
        saveTake.test();
    }

    protected void test() {
        MyAccount myAccount = new MyAccount("007", 0 );
        TakeMoney takeMoney = new TakeMoney("Huazhen", myAccount, 800);
        new Thread(takeMoney).start();

        SaveMoney saveMoney = new SaveMoney("Charles", myAccount, 800);
        new Thread(saveMoney).start();

        SaveMoney saveMoney2 = new SaveMoney("Min Xue", myAccount, 800);
        new Thread(saveMoney2).start();

    }
}
