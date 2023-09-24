package chapater13.others;

import java.io.RandomAccessFile;
import java.net.InetAddress;

public class InetAddressTest {
    public static void main(String[] args) throws Exception {
        InetAddress ip = InetAddress.getByName("www.sohu.com");
        Boolean bl = ip.isReachable(3000);
        if (bl == true) {
            System.out.println("Sohu website is reachable");
        }
        System.out.println("Host address " + ip.getHostAddress()  + ", host name " +  ip.getHostName());
        byte[] temp = new byte[127];
        InetAddress iplocal = InetAddress.getByAddress("localhost", new byte[]{127,0,0,1});
        System.out.println("ip address " + iplocal.getHostName() + "," + iplocal.getHostAddress());
        InetAddress iplocal2 = InetAddress.getByAddress(new byte[]{127,0,0,1});
        System.out.println("ip address " + iplocal.getHostName() + "," + iplocal.getHostAddress());

    }
}
