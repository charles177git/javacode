package chapater12.practise;

class Account {
    private String accountNumber;
    private double balance = 0;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

}

public class DepositWithdrawAccount extends Thread {
    //flag is false mean no money
    private boolean flag = false;
    private Account account;
    private String name;
    private double money;

    public DepositWithdrawAccount() {

    }

    public DepositWithdrawAccount(String name, Account account, double money) {
        this.name = name;
        this.account = account;
        this.money = money;
    }


    public static void main(String[] args) {
        Account account1 = new Account("001", 0);
        DepositWithdrawAccount depositWithdrawAccount = new DepositWithdrawAccount("Charles" , account1, 800);
        System.out.println(depositWithdrawAccount.name + ", " + depositWithdrawAccount.money +
                depositWithdrawAccount.account.getAccountNumber() + "," + depositWithdrawAccount.account.getBalance());
        new Thread(depositWithdrawAccount, "Charles").start();
        DepositWithdrawAccount depositWithdrawAccount1 = new DepositWithdrawAccount("XueMin" , account1, 800);
        new Thread(depositWithdrawAccount1, "XueMin").start();

        DepositWithdrawAccount depositWithdrawAccount2 = new DepositWithdrawAccount("Huazhen" , account1, -800);
        new Thread(depositWithdrawAccount2, "Huazhen").start();
    }

    protected void test() {
        Account account1 = new Account("001", 0);
        DepositWithdrawAccount depositWithdrawAccount1 = new DepositWithdrawAccount("Charles", account1, 800);

    }


    protected void deposit() {
        try {
            //if no money, can deposit money
            if (!flag) {
                this.account.setBalance(money);
                System.out.println("Balance is " + this.account.getBalance() + ", name " + this.name + " saves " + money);
                //has money.
                flag = true;
                notify();
            } else {
                wait();
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    protected void withdraw() {
        try {
            //no money,
            if (!flag) {
                wait();
            }
            //has money can take money,
            else {
                this.account.setBalance(money);
                System.out.println("Balance is " + this.account.getBalance() + ", name takes " + money);
                notifyAll();
                flag = false;
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    protected synchronized void action() {
        if (this.account.getBalance() <= 0 && this.money >0) {
            this.account.setBalance(money);
            System.out.println("account balance " + this.account.getBalance() + ", " + this.name + " deposits " + this.money);
        }
        if (this.account.getBalance() > 0 && this.money <= 0) {
            this.account.setBalance(money);
            System.out.println("account balance " + this.account.getBalance() + ", " + this.name + " takes " + this.money);
        }
    }

    public void run() {
//        withdraw();
//        deposit();
        action();
    }

}
