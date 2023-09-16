package chapater3;

import chapater4.practise2.Teacher;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TruncateString {
    public static void main(String args[]) {
        TruncateString truncateString = new TruncateString();
        String testString = "";
        String testSTtring2 ="";
        testString = "abdeeo2323233sdf";
        testSTtring2 = "一丁aa七b万c丈dd";
        try {
            truncateString.test(testString, 1, 4);
            System.out.println();
            truncateString.test(testString, 1, 50);
            System.out.println();
            truncateString.test(testString, 0, 10);
            System.out.println();
//            truncateString.test(testString, 11, -4);
//            System.out.println();

            truncateString.test(testSTtring2, 0, 4);
            System.out.println();
            truncateString.test(testSTtring2, 2, 50);
            System.out.println();
            truncateString.test(testSTtring2, 0, 5);
            System.out.println();
            truncateString.test(testSTtring2, 1, 4);
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        //to test access other package public class and public method.
        truncateString.access();
    }

    public void test(String sourceStr, int start, int end) throws Exception {
        if (start < 0 || end < start) {
            throw new Exception("position is not right, please check");
        }
        //put source string covert to byte char
        byte[] varByte;
        //put destination byte char.
        byte[] truncateByte;
        //print each 8 bit of byte.
        byte[] singleCharacter = new byte[8];
        varByte = sourceStr.getBytes(StandardCharsets.UTF_8);
        //ISO_8859_1 does not know Chinese Character.
//        varByte = sourceStr.getBytes(StandardCharsets.ISO_8859_1);
        //summary how many bytes.
        int byteLength = varByte.length;
        truncateByte = new byte[byteLength];
        int j = 0;
        for (int i = 0; i < byteLength; i++) {
            if (i < start) {
                continue;
            }
            if (i == start || i < end) {
                truncateByte[j] = varByte[i];
//                singleCharacter[j] = varByte[i];
                char asciiCharacter = (char)truncateByte[j];
                System.out.print(asciiCharacter);

//                System.out.print(singleCharacter);
//                System.out.print(Arrays.toString(singleCharacter));
                j++;
            }
        }
    }

    public void access() {
        Teacher teacher = new Teacher("Li", 56, "male", "Physics");
        teacher.setAge(57);
        System.out.println("name " + teacher.getName() +", age " + teacher.getAge() + ", car " + teacher.getCar());

    }


}
