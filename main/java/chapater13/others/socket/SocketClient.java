package chapater13.others.socket;

import java.io.*;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {
        SocketClient socketClient = new SocketClient();
        try {
            socketClient.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected  void test() throws Exception {
        Socket socket  = new Socket("127.0.0.1", 20001);
        String say = "Hello Server, good afternoon, happy Sunday";
        {
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            System.out.println("Server side: " + line);

            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println("I am client, I say good afternoon and happy Sunday");
        }
    }
}
