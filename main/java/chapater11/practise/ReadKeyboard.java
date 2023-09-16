package chapater11.practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadKeyboard {
    public static void main(String[] args) {
        ReadKeyboard readKeyboard = new ReadKeyboard();
        readKeyboard.test();
    }

    protected void test() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String line = "";

        {
            try {
                while ((line = br.readLine()) != null) {
                    if (line.equals("exit")){
                        System.exit(0);
                    }
                    System.out.println(line);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

    }
}
