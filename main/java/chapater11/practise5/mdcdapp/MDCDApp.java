package chapater11.practise5.mdcdapp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MDCDApp {
    public static void main(String[] args) {
        MDCDApp mdcdApp = new MDCDApp();
        try {
            mdcdApp.test();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    protected void test() throws IOException {
        String dir = "/test/aba";
        File cddir = new File(dir);
        if (cddir.exists()) {
            System.out.println("the dir already exists");
            Files.list(Paths.get(dir)).forEach(item -> System.out.println(item));
        } else {
            cddir.mkdirs();
            System.out.println("MD DIR successfully");
            Files.list(Paths.get(dir)).forEach((item -> System.out.println(item)));
        }

    }

}
