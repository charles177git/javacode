package chapater11.practise2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GetFileCount {
    public static void main(String[] args) {
        GetFileCount getFileCount = new GetFileCount();
        try {

            getFileCount.test();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    protected void test() throws IOException {
        int filecount =0;
        int dircount = 0;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String dir = br.readLine().trim();
        List<Path> lists = new ArrayList<Path>();
        Files.list(Paths.get(dir)).forEach(file -> {
            System.out.println(file);
            lists.add(file);
        });
        //because in Lambda express can not use any no final value, so convert to lists.
        for (Path path: lists) {
            if (path.toFile().isFile()) {
                filecount++;
            }
            if (path.toFile().isDirectory()) {
                dircount++;
            }
        }
        System.out.println("File count " + filecount);
        System.out.println("Directory count " + dircount);
    }
}
