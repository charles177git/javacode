package chapater13.others.socketthread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != "") {
                System.out.println(line);
                for (Socket socketclient : ServerSideSocket.socketList) {
                    PrintStream ps = new PrintStream(socketclient.getOutputStream());
                    ps.println(line);
                }
            }
        } catch (IOException ie) {
            ie.printStackTrace();
            ServerSideSocket.socketList.remove(socket);
        }
    }

}


class ServerSideSocket {
    public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(20007);
            while (true) {
                Socket socket = serverSocket.accept();
                socketList.add(socket);

//                new Thread(new ServerThread(socket)).start();
                new ServerThread(socket).start();
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    protected void test() {

    }
}