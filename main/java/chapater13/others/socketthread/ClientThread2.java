package chapater13.others.socketthread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientThread2 extends Thread {
    private  Socket socket;
    public ClientThread2(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String content = "";
            while ((content = bufferedReader.readLine()) != null) {
                System.out.println(content);
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

}



class ClientSideSocket2 {
    public static void main(String[] args) {

        ClientSideSocket2 clientSideSocket = new ClientSideSocket2();
        clientSideSocket.test();
    }

    protected void test() {
        try {
            Socket socket = new Socket("localhost", 20007);
            new ClientThread2(socket).start();

            PrintStream ps = new PrintStream(socket.getOutputStream());
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != "") {
                ps.println(line);
            }
        } catch (IOException ie) {
            ie.printStackTrace();
            ie.getMessage();
        }
    }

}