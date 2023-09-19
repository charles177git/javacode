package chapaterother.withdrawdeposit;


public class WithdrawDeposit {
    public static void main(String[] args) {
        WithdrawDeposit withdrawDeposit = new WithdrawDeposit();
        withdrawDeposit.test();
    }
    protected void test() {
        Account account = new Account("009", 0);
        new Withdraw(account, 100, "Charles").start();
        new Deposit(account, 100, "Xue").start();
        new Deposit(account, 100, "Huazhen").start();
    }
}



class Withdraw extends Thread {
    private Account account;
    private double money;
    private String person;

    public Withdraw(Account account, double money, String person) {
        this.account = account;
        this.money = money;
        this.person = person;
    }

    public void run() {
        for (int i=0; i < 100; i++) {
            this.account.take(money, person);
        }
    }
}


class Deposit extends Thread {
    private Account account;
    private double money;
    private String person;

    public Deposit(Account account, double money, String person) {
        this.account = account;
        this.money = money;
        this.person = person;
    }

    public void run() {
        for (int i=0; i < 100; i++) {
            this.account.save(money, person);
        }
    }
}


class Account {
    private boolean flag = false;
    private Account account;
    private String accountName;
    private double balance;
    public Account(String name, double balance) {
        this.accountName = name;
        this.balance = balance;
    }
    protected synchronized void save(double money, String name) {
        try {
            if (flag) {
                wait();
            } else {
                this.balance += money;
                System.out.println(name + " saves " + money + ", the balance " + this.balance);
                flag = true;
                notifyAll();
            }
        }catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    protected synchronized void take(double money, String name) {
        try {
            if (!flag) {
                wait();
            } else {
                this.balance -= money;
                System.out.println(name + " takes " + money + ", the balance is " + this.balance);
                flag = false;
                notifyAll();
            }
        }catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}