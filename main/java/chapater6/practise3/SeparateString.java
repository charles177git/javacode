package chapater6.practise3;

import java.util.Arrays;

public class SeparateString {
    public static void main(String[] args) {
        SeparateString separateString = new SeparateString();
        separateString.test();
    }

    public void test() {
        String source = "A1B2C3D4E5F6G7H8";
        char chars[] = new char[10];
        char numbers[] = new char[10];
        int j = 0;
        int k = 0;
        for (int i = 0; i < source.length(); i++) {
            char single = source.charAt(i);
            if (single >= 65 && single <= 90) {
                chars[j] = single;
                j++;
            }
            if (single >= 48 && single <= 57) {
                numbers[k] = single;
                k++;
            }
        }
        for (int jj = 0; jj < j; jj++) {
            System.out.println(chars[jj]);
        }
        for (int jj = 0; jj < k; jj++) {
            System.out.println(numbers[jj]);
        }
        //array can not print directly using Arrays.toString().
        System.out.println(Arrays.toString(chars));
        System.out.println(Arrays.toString(numbers));

    }


}
