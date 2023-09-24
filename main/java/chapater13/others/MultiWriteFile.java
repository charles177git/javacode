package chapater13.others;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class MultiWriteFile {
    private String fileName;
    private int size;
    private WriteThread writeThreads[];
    private RandomAccessFile ras;
    public MultiWriteFile(String fileName, int threadNum) {
        this.fileName = fileName;
//        RandomAccessFile ras = new RandomAccessFile("/home/charles/Downloads/test.txt", "rw");
        try {
           ras = new RandomAccessFile(fileName, "rw");
        } catch (FileNotFoundException fof) {
            fof.printStackTrace();
        }
        this.size = 350;
        this.writeThreads = new WriteThread[threadNum];

    }

    public static void main(String[] args) {
        {
            MultiWriteFile multiWriteFile = new MultiWriteFile("/home/charles/Downloads/test.txt", 2);
            multiWriteFile.test();
        }
    }

    protected void test() {
        List<String> lists = new ArrayList();
        lists.add("this is the first line;\n");
        lists.add("this is the second line;\n");
        lists.add("this is the third line;\n");
        lists.add("this is the fourth line;\n");
        lists.add("this is the fifth line;\n");

        List<String> lists2 = new ArrayList<>();
        lists2.add("this is the sixth line;\n");
        lists2.add("this is the seventh line;\n");
        lists2.add("this is the eighth line;\n");
        lists2.add("this is the nineth line;\n");
        lists2.add("this is the tenth line;\n");

        for (int i = 0; i < this.writeThreads.length; i++) {
            if (i == 0) {
                writeThreads[i] = new WriteThread(ras, lists, i);
            } else {
                writeThreads[i] = new WriteThread(ras, lists2, i);
            }
            writeThreads[i].start();
        }


    }
}


class WriteThread extends Thread {
    String file;
    int size;
    int startposition;
    List<String> content;
    RandomAccessFile ras;
    int num;
    public WriteThread(RandomAccessFile ras, List<String> content, int num) {
        this.ras = ras;
//        this.size = size;
//        this.startposition = startposition;
        this.content = content;
        this.num = num;
    }

    public void run() {
        String temp = "";
        for (String line : content) {
            temp += line;
        }
        System.out.println(temp);
        try {
            ras.setLength(308);
            ras.seek(num * 154);
            ras.writeChars(temp);
//            OutputStreamWriter osw = new OutputStreamWriter(ras);
//            osw.write(standChar, 0, standChar.length);
//            ras.close();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

