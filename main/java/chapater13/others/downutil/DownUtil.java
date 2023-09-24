package chapater13.others.downutil;


import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.*;
/**
 * Description:
 * <br/>ÍøÕŸ: <a href="http://www.crazyit.org">·è¿ñJavaÁªÃË</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class DownUtil
{
    // ¶šÒåÏÂÔØ×ÊÔŽµÄÂ·Ÿ¶
    private String path;
    // Öž¶šËùÏÂÔØµÄÎÄŒþµÄ±£ŽæÎ»ÖÃ
    private String targetFile;
    // ¶šÒåÐèÒªÊ¹ÓÃ¶àÉÙÏß³ÌÏÂÔØ×ÊÔŽ
    private int threadNum;
    // ¶šÒåÏÂÔØµÄÏß³Ì¶ÔÏó
    private DownThread[] threads;
    // ¶šÒåÏÂÔØµÄÎÄŒþµÄ×ÜŽóÐ¡
    private int fileSize;

    public DownUtil(String path, String targetFile, int threadNum)
    {
        this.path = path;
        this.threadNum = threadNum;
        // ³õÊŒ»¯threadsÊý×é
        threads = new DownThread[threadNum];
        this.targetFile = targetFile;
    }

    public void download() throws Exception
    {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
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
        conn.setRequestProperty("Connection", "Keep-Alive");
        // µÃµœÎÄŒþŽóÐ¡
        fileSize = conn.getContentLength();
        if (fileSize == -1) {
            System.out.println("File can not read size");
            return;
            //            fileSize = 629772;
        }
        conn.disconnect();
        int currentPartSize = fileSize / threadNum + 1;
        RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
        // ÉèÖÃ±ŸµØÎÄŒþµÄŽóÐ¡
        file.setLength(fileSize);
        System.out.println("stream size " + fileSize);
        file.close();
        for (int i = 0; i < threadNum; i++)
        {
            // ŒÆËãÃ¿ÌõÏß³ÌµÄÏÂÔØµÄ¿ªÊŒÎ»ÖÃ
            int startPos = i * currentPartSize;
            // Ã¿žöÏß³ÌÊ¹ÓÃÒ»žöRandomAccessFileœøÐÐÏÂÔØ
            RandomAccessFile currentPart = new RandomAccessFile(targetFile, "rw");
            // ¶šÎ»žÃÏß³ÌµÄÏÂÔØÎ»ÖÃ
            currentPart.seek(startPos);
            // ŽŽœšÏÂÔØÏß³Ì
            threads[i] = new DownThread(startPos, currentPartSize, currentPart);
            // Æô¶¯ÏÂÔØÏß³Ì
            threads[i].start();
        }
    }

    // »ñÈ¡ÏÂÔØµÄÍê³É°Ù·Ö±È
    public double getCompleteRate()
    {
        // Í³ŒÆ¶àÌõÏß³ÌÒÑŸ­ÏÂÔØµÄ×ÜŽóÐ¡
        int sumSize = 0;
        for (int i = 0; i < threadNum; i++)
        {
            sumSize += threads[i].length;
        }
        // ·µ»ØÒÑŸ­Íê³ÉµÄ°Ù·Ö±È
        return sumSize * 1.0 / fileSize;
    }

    public static void main(String[] args) {
//        DownUtil downUtil = new DownUtil();
//        DownUtil downUtil = new DownUtil("https://p0.meituan.net/shaitu/9b7feecae400f6320e9783182f13e2af1493728.jpg", "/home/charles/Downloads/good.jpg" , 5 );
//        DownloadUtil downUtil = new DownloadUtil("https://p0.meituan.net/shaitu/9b7feecae400f6320e9783182f13e2af1493728.jpg", "/home/charles/Downloads/good.jpg" , 2 );
//        https://www.parklands.com.au/images/park-flexslider-home/slider-garden-suite-2017.jpg
//        DownUtil downUtil = new DownUtil("https://img.pconline.com.cn/images/upload/upc/tx/photoblog/1806/10/c0/92030777_1528585125365.jpg", "/home/charles/Downloads/good.jpg" , 5 );
        DownUtil downUtil = new DownUtil("https://p0.meituan.net/shaitu/9b7feecae400f6320e9783182f13e2af1493728.jpg", "/home/charles/Downloads/good.jpg" , 5 );

        try {
            downUtil.download();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class DownThread extends Thread
    {
        // µ±Ç°Ïß³ÌµÄÏÂÔØÎ»ÖÃ
        private int startPos;
        // ¶šÒåµ±Ç°Ïß³ÌžºÔðÏÂÔØµÄÎÄŒþŽóÐ¡
        private int currentPartSize;
        // µ±Ç°Ïß³ÌÐèÒªÏÂÔØµÄÎÄŒþ¿é
        private RandomAccessFile currentPart;
        // ¶šÒåÒÑŸ­žÃÏß³ÌÒÑÏÂÔØµÄ×ÖœÚÊý
        public int length;

        public DownThread(int startPos, int currentPartSize, RandomAccessFile currentPart)
        {
            this.startPos = startPos;
            this.currentPartSize = currentPartSize;
            this.currentPart = currentPart;
        }

        @Override
        public void run()
        {
            try
            {
                URL url = new URL(path);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
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
                InputStream inStream = conn.getInputStream();
                // Ìø¹ýstartPosžö×ÖœÚ£¬±íÃ÷žÃÏß³ÌÖ»ÏÂÔØ×ÔŒºžºÔðÄÄ²¿·ÖÎÄŒþ¡£
                System.out.println("now is reading stream length " + conn.getContentLength());
                inStream.skip(this.startPos);
                byte[] buffer = new byte[1024];
                int hasRead = 0;
                // ¶ÁÈ¡ÍøÂçÊýŸÝ£¬²¢ÐŽÈë±ŸµØÎÄŒþ
                while (length < currentPartSize && (hasRead = inStream.read(buffer)) != -1)
                {
                    currentPart.write(buffer, 0, hasRead);
                    // ÀÛŒÆžÃÏß³ÌÏÂÔØµÄ×ÜŽóÐ¡
                    length += hasRead;
                }
                currentPart.close();
                inStream.close();
                System.out.println("read size " + length + ", passed size " + currentPartSize);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}