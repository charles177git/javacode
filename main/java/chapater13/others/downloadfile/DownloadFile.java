package chapater13.others.downloadfile;


import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFile {
    private String url;
    private String saveFile;
    private MultiGetFile multiGetFiles[];
    private int threadNum;

    public DownloadFile(String url, String saveFile, int threadNum) {
        this.url = url;
        this.saveFile = saveFile;
        this.threadNum = threadNum;
        multiGetFiles = new MultiGetFile[threadNum];
    }


    public static void main(String[] args) {
        DownloadFile downloadFile = new DownloadFile("https://p0.meituan.net/shaitu/9b7feecae400f6320e9783182f13e2af1493728.jpg", "/home/charles/Downloads/good.jpg", 5);
        try {
            downloadFile.download();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    protected void download() throws Exception {
        URL remoteURL = new URL(this.url);

        HttpURLConnection conn = (HttpURLConnection) remoteURL.openConnection();
        conn.setReadTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        conn.setRequestProperty(
                "Accept",
                "image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
                        + "application/x-shockwave-flash, application/xaml+xml, "
                        + "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
                        + "application/x-ms-application, application/vnd.ms-excel, "
                        + "application/vnd.ms-powerpoint, application/msword, */*");
        conn.setRequestProperty("Accept-Language", "zh-CN");
        conn.setRequestProperty("Charset", "UTF-8");
        conn.setRequestProperty("Connection", "Keep-Alive");
        int streamLength = conn.getContentLength();
        if (streamLength == -1) {
            System.out.println("Can not access file, return");
            conn.disconnect();
            return;
        }
        RandomAccessFile ras = new RandomAccessFile(saveFile, "rw");
        ras.setLength(streamLength);
        ras.close();
        conn.disconnect();
        //close the stream.

        System.out.println("stream size " + streamLength);
        int partSize = streamLength / threadNum + 1;
        for (int i = 0; i < multiGetFiles.length; i++) {
            int startPoint = i * partSize;
            RandomAccessFile rasPart = new RandomAccessFile(saveFile, "rw");
            rasPart.seek(startPoint);
            multiGetFiles[i] = new MultiGetFile(rasPart, startPoint, partSize, url);
            multiGetFiles[i].start();
        }
    }


}

class MultiGetFile extends Thread {
    private RandomAccessFile rasPart;
    private String url;
    private int startPoint;
    private int partSize;

    public MultiGetFile(RandomAccessFile rasPart, int startPoint, int partSize, String url) {
        this.rasPart = rasPart;
        this.startPoint = startPoint;
        this.partSize = partSize;
            this.url = url;
    }

    public void run() {
        try {
            URL remoteUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) remoteUrl.openConnection();
            //the next sentence makes me very wrong, because no set property finish, then read content and length causes me half a day.
//                int streamLength = conn.getContentLength();
            conn.setConnectTimeout(5 * 1000);
            conn.setRequestMethod("GET");
            conn.setRequestProperty(
                    "Accept",
                    "image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
                            + "application/x-shockwave-flash, application/xaml+xml, "
                            + "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
                            + "application/x-ms-application, application/vnd.ms-excel, "
                            + "application/vnd.ms-powerpoint, application/msword, */*");
            conn.setRequestProperty("Accept-Language", "zh-CN");
            conn.setRequestProperty("Charset", "UTF-8");
            int streamLength = conn.getContentLength();
            System.out.println("thread reads stream length " + streamLength);
            InputStream inStream = conn.getInputStream();
            inStream.skip(startPoint);
            int readLength = 0;
            int total = 0;
            byte[] bytes = new byte[1024];
            while (total < partSize && (readLength = inStream.read(bytes)) != -1) {
                rasPart.write(bytes, 0, readLength);
                total += readLength;
            }
            System.out.println("five parts real read length " + total + ", part passed length " + partSize);
            rasPart.close();
            inStream.close();
        }catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

}



