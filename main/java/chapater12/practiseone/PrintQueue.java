package chapater12.practiseone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        printQueue.test();
    }

    protected void test() {
        Map<String, List> map = new HashMap();
        List<Integer> numbers = new ArrayList();
        List<String> alphabet = new ArrayList<>();

        for (int i = 65; i < (65 + 26); i++) {
            char a = (char)i;
            alphabet.add(String.valueOf(a));
            alphabet.add(String.valueOf(a));
        }
        //alphabet queue.
        map.put("alphabet", alphabet);

        int k = 0;
        for (int i = 1; i< 53; i++) {
            if (k % 2 == 1) {
                numbers.add(i);
                numbers.add(i - 1);
                numbers.add(i);
                k = 0;
            } else {
                numbers.add(i);
                k++;
            }
        }
//        number queue.
        map.put("number", numbers);

        PrintLetter printLetter = new PrintLetter(map);

        new Numbers(printLetter).start();
        new Alphabet(printLetter).start();
    }

}


class Numbers extends Thread {
    private PrintLetter printLetter;
    public Numbers(PrintLetter printLetter) {
        this.printLetter = printLetter;
    }

    public void run() {
        for  (int j=0; j < 52; j++) {
            this.printLetter.outNumber(j);
        }
    }
}


class Alphabet extends Thread {
    private PrintLetter printLetter;
    public Alphabet(PrintLetter printLetter) {
        this.printLetter = printLetter;
    }
    public void run() {
        for (int i = 0; i < 52; i++) {
            printLetter.outputAlphabet(i);
        }
    }
}

class PrintLetter {
    private Map<String, List> map;
    private boolean flag = true;
    private final ReentrantLock reentrantLock  = new ReentrantLock();
    private final Condition condition = reentrantLock.newCondition();
    public PrintLetter(Map map) {
        this.map = map;
    }
    protected void outNumber(int i) {
        reentrantLock.lock();
        try {
            if (!flag) {
                condition.await();
            }
//            one time to print out 2 characters.
            else {
                List lists = map.get("number");
                System.out.println(lists.get(2*i));
                System.out.println(lists.get(2*i + 1));
                flag = false;
                condition.signalAll();
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    protected void outputAlphabet(int i) {
        reentrantLock.lock();
        try {
            if (flag) {
                condition.await();
            } else {
                List lists = map.get("alphabet");
                System.out.println(lists.get(i));
                flag = true;
                condition.signalAll();
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

}