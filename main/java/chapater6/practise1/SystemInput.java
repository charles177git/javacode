package chapater6.practise1;

import java.util.Scanner;

public class SystemInput {
    private int[] values;

    public SystemInput() {
        values = new int[10];
    }

    public static void main(String[] args) {
        SystemInput systemInput = new SystemInput();
        systemInput.readNumber();
        systemInput.test();
    }

    protected void readNumber() {
        Scanner scanner = new Scanner(System.in);
        int j = 0;
        while (scanner.hasNext() && j < 10) {
            try {
                int val = Integer.parseInt(scanner.next());
                System.out.println("int val " + val);
                values[j] = val;
                j++;
            } catch (NumberFormatException ne) {
                ne.printStackTrace();
            }
        }
    }


    public void test() {
        int i = 0;
        int maxValue = 0;
        int minValue = 10000;
        double average = 0;
        double total = 0;
        int temp = 0;
        for (int j = 0; j < 10; j++) {
            if (maxValue < values[j]) {
                maxValue = values[j];
            }
            if (minValue > values[j]) {
                minValue = values[j];
            }
            total += values[j];
        }
        average = Math.round(total / 10);
        System.out.println("max value " + maxValue + ", min value = " + minValue + ", average value = " + average);

    }

}
