package chapater7.practise2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListTest {
    private List<String> lists;

    public static void main(String[] args) {
        ListTest listTest = new ListTest();
        listTest.test();
    }

    protected void test() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        lists = new ArrayList<>();
        while (scanner.hasNext() && count < 10) {
            String element = scanner.next();
            lists.add(count, element);
            count++;
        }

        lists.forEach(val -> System.out.println(val));
        String element1 = lists.get(5);
        String element2 = lists.get(7);
        String element3 = lists.get(2);
        System.out.println("index 5 " + element1 + ", index 7 " + element2 + ", index 2 " + element3);
        lists.remove(3);
        lists.forEach(val -> System.out.println(val));
    }


}

