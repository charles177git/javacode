package chapater7.practise1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetTest {
    private Set<String> set ;
    public static void main(String[] args) {
        SetTest setTest = new SetTest();
        setTest.test();
    }

    public void test() {
        int count = 0;
        set = new HashSet<String>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext() & count < 10) {
            String input  = scanner.next();
            set.add(input);
            count++;
        }
        for (String value : set) {
            System.out.println(value);
        }
    }
}
