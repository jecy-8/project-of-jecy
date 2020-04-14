package jecy.test.webserver.tcp;

import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(10000)) {

            System.out.println("tcp server started on port 10000");
            while (true) {
                Socket s = serverSocket.accept();

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
