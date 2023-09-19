package chapater11.practise5.dir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class DirApp {
    public static void main(String[] args) {
        DirApp dirApp = new DirApp();
        try {
            dirApp.test();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    protected void test() throws IOException {
        Path path = Paths.get(".");
        List<Path> lists = new ArrayList<Path>();
        Files.list(path).forEach(file -> {
            lists.add(file);
        });
        for (Path pathitem : lists) {
            File currentFile = pathitem.toFile();
            long dateUpdate = currentFile.lastModified();
            String fileName = pathitem.toFile().getName();
            if (currentFile.isFile()) {
                long fileSize = currentFile.length();
                System.out.println("I am a file, file name " + fileName + ", file size " + fileSize + ", file modified " + dateUpdate);
            }
            if (currentFile.isDirectory()) {
                System.out.println("I am a directory, directory name " +  fileName +  ", dir modified " + dateUpdate);
            }
        }
    }
}
