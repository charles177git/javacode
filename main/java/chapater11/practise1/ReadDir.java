package chapater11.practise1;


import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class ReadDir {
    public static void main(String[] args) throws IOException {
        ReadDir readDir = new ReadDir();
        readDir.test();
    }

    protected void test() throws IOException {
        //convert byte stream to char stream.
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        Path path = Paths.get(br.readLine().trim());
        System.out.println("read directory is " + path);
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException {
                System.out.println("Access file" + file);
                if (file.endsWith("myfile")) {
                    System.out.println("get the file" + file);
                }
                return FileVisitResult.CONTINUE;
            }
            //this is similar with the next access dir.
            public FileVisitResult postVisitDirectory(Path dir, IOException ioe) {
                System.out.println("Access directory " + dir);
                return FileVisitResult.CONTINUE;
            }
            //this is similar with the other function access directory.
//            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attributes) {
//                System.out.println("Access directory " + dir);
//                return FileVisitResult.CONTINUE;
//            }
        });
    }
}
