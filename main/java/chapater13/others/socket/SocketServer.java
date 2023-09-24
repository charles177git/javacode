package chapater13.others.socket;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        SocketServer socketServer = new SocketServer();
        try {
            socketServer.test();
        } catch (IOException ie) {
            ie.printStackTrace();
            ie.getMessage();
        }
    }

    protected void test() throws IOException {
        ServerSocket server = new ServerSocket(20001);
        {
                Socket socket = server.accept();

//                PrintWriter pw = new PrintWriter(socket.getOutputStream());
                PrintStream ps = new PrintStream(socket.getOutputStream());
                ps.println("Good afternoon, Server says hello to you");

                InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                BufferedReader rd = new BufferedReader(isr);
                String line = rd.readLine();
                System.out.println("Client side: " + line);

        }
    }
}
