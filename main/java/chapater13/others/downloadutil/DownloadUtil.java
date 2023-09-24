package chapater13.others.downloadutil;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadUtil {
    private String path;
    private String saveFile;
    private int threadNum = 0;
    private DownloadThread[] threads;
    private int fileSize;
//    private static RandomAccessFile ras;
    public DownloadUtil(String path, String saveFile, int threadNum) {
        this.path = path;
        this.saveFile = saveFile;
        this.threadNum = threadNum;
        this.threads = new DownloadThread[threadNum];
//        this.ras = new RandomAccessFile(saveFile, "rw");
    }

    public void download()  throws Exception {
        URL url = new URL(this.path);
        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty(
                "Accept",
                "image/gif, image/jpeg, image/pjpeg, image/jpg," +
                "application/x-shock-flash, application/xaml+xml," +
                "application/x-ms-application, application/vnd.ms-excel," +
                "application/msword, */*");
        httpURLConnection.setRequestProperty("charset", "UTF-8");
        httpURLConnection.setRequestProperty("connection", "Keep-Alive");

        fileSize  = httpURLConnection.getContentLength();
        System.out.println("total stream size " + fileSize);
        if (fileSize == -1) {
//            fileSize = 5595937 ;
            System.out.println("Can not access the resource, return");
            httpURLConnection.disconnect();
            return;
        }
        //auto close RandomAccessFile stream.
        {
            RandomAccessFile ras = new RandomAccessFile(saveFile, "rw");
            ras.setLength(fileSize);
            ras.close();
            int sectionSize = fileSize / threadNum + 1;
            httpURLConnection.disconnect();
            for (int i = 0; i < threadNum; i++) {
                //when multiple thread, seek position.
                RandomAccessFile raspart = new RandomAccessFile(saveFile, "rw");
                raspart.seek(sectionSize);
                threads[i] = new DownloadThread(raspart, i * sectionSize, sectionSize, path);
                threads[i].start();
            }
        }
    }

    public static void main(String[] args)  {
//        DownUtil downUtil = new DownUtil("https://downapi.mydown.com/down/s/hp717179730_10,4,0", "/home/charles/Downloads/aa.exe" , 5 );
//        http://pic1.win4000.com/wallpaper/2/568f86fcb6d7a.jpg http://pic1.win4000.com/wallpaper/c/57ec71ee4ea0d.jpg
//        http://img.knetreg.cn/group4/M00/33/35/yq0KYV3dzWaAW2SlAABUmzF62gs162.jpg https://www.parklands.com.au/images/park-flexslider-home/slider-garden-suite-2017.jpg
//        https://p0.meituan.net/shaitu/9b7feecae400f6320e9783182f13e2af1493728.jpg
        DownloadUtil downUtil = new DownloadUtil("https://p0.meituan.net/shaitu/9b7feecae400f6320e9783182f13e2af1493728.jpg", "/home/charles/Downloads/good.jpg" , 2);
        try {
            downUtil.download();
        } catch(Exception ie) {
            ie.printStackTrace();
        }finally {
//            ras.close();
        }
    }

    protected void test() {

    }
}


class DownloadThread extends Thread {
    private URL url;
    private int size;
    private int startpoint;
    private RandomAccessFile raspart;
    private String path;
    public DownloadThread(RandomAccessFile raspart, int startpoint, int size, String path) {
        this.raspart  = raspart;
        this.startpoint = startpoint;
        this.size = size;
//        this.url = url;
        this.path = path;
    }

    public void run() {
        try {
            URL url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            System.out.println("reading stream size " + httpURLConnection.getContentLength());
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty(
                    "Accept",
//                    "image/gif, image/jpeg, image/pjpeg, image/jpg," +
//                            "application/x-shock-flash, application/xaml+xml," +
//                            "application/x-ms-application, application/vnd.ms-excel," +
//                            "application/msword, */*");

                    "image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
                            + "application/x-shockwave-flash, application/xaml+xml, "
                            + "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
                            + "application/x-ms-application, application/vnd.ms-excel, "
                            + "application/vnd.ms-powerpoint, application/msword, */*");
            httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
//            httpURLConnection.setRequestProperty("https.protocols", "TLSv1.2");
            InputStream inStream = httpURLConnection.getInputStream();
            //both skip startpoint position
            inStream.skip(startpoint);

            byte[] bytes = new byte[1024];
            int length = 0;
            int total =0;

            while ( total < size && (length = inStream.read(bytes, 0, bytes.length))!= -1) {
                raspart.write(bytes, 0, length);
                total += length;
            };
            System.out.println("total " + total + ", size " + size);
            raspart.close();
            inStream.close();
//            inStream.close();
//            ras.close();
//            httpURLConnection.disconnect();
        }catch(IOException ie) {
            ie.printStackTrace();
        }
    }
}
