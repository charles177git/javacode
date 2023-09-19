package chapater12.practise1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *the two queues the elements is repeated, because thread share the memory, so when i++ in each loop will look like i+2,
 */
public class PrintString {
    public static void main(String[] args) {
        PrintString printString = new PrintString();
        printString.test();
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
        map.put("number", numbers);

        PrintLetter printLetter = new PrintLetter(map);

        new Alphabet(printLetter).start();
        new Numbers(printLetter).start();
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
    public PrintLetter(Map map) {
        this.map = map;
    }

    protected synchronized void outNumber(int i) {
        try {
            if (!flag) {
                wait();
            }
//            one time to print out 2 characters.
            else {
                List lists = map.get("number");
                System.out.println(lists.get(2*i));
                System.out.println(lists.get(2*i + 1));
                flag = false;
                notifyAll();
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    protected synchronized void outputAlphabet(int i) {
        try {
            if (flag) {
                wait();
            } else {
                List lists = map.get("alphabet");
                System.out.println(lists.get(i));
                flag = true;
                notifyAll();
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

}