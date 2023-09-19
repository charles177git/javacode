package chapater12.practise.practiseone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintQueue {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        printQueue.test();
    }

    protected void test() {
        QueueLine number_queue = new QueueLine();
        QueueLine alphabet_queue = new QueueLine();
        new Thread(number_queue, "number_queue").start();
        new Thread(alphabet_queue, "alphabet_queue").start();

    }
}


class QueueLine implements Runnable {
    private List<String> alphabet;
    private List<Integer> numbers;
    private Map<String, List> map;

    public QueueLine() {
        alphabet = new ArrayList<>();
        numbers = new ArrayList<>();
        map = new HashMap<>();
        for (int i = 65; i < (26 + 65); i++) {
            alphabet.add(String.valueOf((char) i));
        }
        for (int i = 1; i < 53; i++) {
            numbers.add(i);
        }
        map.put("number", numbers);
        map.put("alphabet", alphabet);
    }

    public void run() {
        synchronized (this.map) {
            if (Thread.currentThread().getName() == "number_queue") {
                System.out.println("Thread name " + Thread.currentThread().getName());
                List<Integer> lists = this.map.get("number");
                int i = 0;
                int k = 0;
                try {
                    while (i < lists.size()) {
                        System.out.println(lists.get(i));
                        if (k % 2 == 1) {
                            k = 0;
                            Thread.sleep(10);
                        } else {
                            k++;
                        }
                        i++;
                    }
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
            if (Thread.currentThread().getName() == "alphabet_queue") {
                System.out.println("Thread name " + Thread.currentThread().getName());
                List<String> words = this.map.get("alphabet");
                int j = 0;
                try {
                    while (j < words.size()) {
                        System.out.println(words.get(j));
                        Thread.sleep(10);
                        j++;
                    }
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        } //end of synchronized
    }
}
