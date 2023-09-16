package chapater11.practise;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class PathTest {
    public static void main(String[] args) throws IOException {
        PathTest pathTest = new PathTest();
        pathTest.test();
        pathTest.testFiles();
        pathTest.fileVisitorTest();
    }

    protected void test() {
        Path path = Paths.get(".");
        System.out.println(path.getNameCount());

        Path absolutePath = path.toAbsolutePath();
        System.out.println(absolutePath);

        System.out.println("absolutepath root " + absolutePath.getRoot());
        System.out.println("absolutepath name count " + absolutePath.getNameCount());

        System.out.println(absolutePath.getName(2));

        Path path2 = Paths.get("/", "home", "charles");
        System.out.println(path2);

    }
    
    protected void testFiles() throws IOException {
        String file = "/home/charles/Downloads/testconnect.php";
        System.out.println(Files.size(Paths.get(file)));
        System.out.println(Files.isHidden(Paths.get(file)));
        
        Files.lines(Paths.get(file)).forEach(line -> System.out.println(line));
        List<String> lines = new ArrayList<>() ;
        //read file method1
        lines = Files.readAllLines(Paths.get(file), Charset.forName("gbk"));

        for (String line : lines) {
            System.out.println(line);
        }
        //read file method2.
        Files.lines(Paths.get(file), Charset.forName("gbk")).forEach(line -> System.out.println(line));
        //list dir.
        Files.list(Paths.get(".")).forEach(filedir -> System.out.println(filedir));
        
        Files.copy(Paths.get(file), new FileOutputStream("/home/charles/Downloads/one.txt"));
        List<String> lists = new ArrayList<>();
        lists.add("Good morning");
        lists.add("Happy a new day");
        Files.write(Paths.get("/home/charles/Downloads/two.txt"), lists, Charset.forName("gbk"));
        FileStore fileStore = Files.getFileStore(Paths.get("/"));
        System.out.println(fileStore.getTotalSpace() + "," + " " + fileStore.getUsableSpace());

    }

    protected void fileVisitorTest() throws IOException {
        Files.walkFileTree(Paths.get("/","home","charles","Documents"), new SimpleFileVisitor<Path>(){
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("access file " + file);
                if (file.endsWith("onetext")) {
                    System.out.println("get the file " + file);
                }
                //this does not work.
                if (file.equals("onetext")) {
                    System.out.println("get the file again " + file);
                }
                return FileVisitResult.CONTINUE;
            }
            public FileVisitResult preVisitDirectory(Paths dir, BasicFileAttributes attrs) {
                System.out.println("access " + dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

}
