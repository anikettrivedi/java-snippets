package socketprogramming;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {

        System.out.println("Waiting for client.");
        try (
                // create server socket
                ServerSocket ss = new ServerSocket(10000);

                // blocking call, waits for the client to establish connection
                Socket socket = ss.accept();

                // read data from socket
                InputStream socketByteInputStream = socket.getInputStream();
                InputStreamReader socketCharInputStream = new InputStreamReader(socketByteInputStream);
                BufferedReader socketStringInputStream = new BufferedReader(socketCharInputStream);

                // write data to socket
                OutputStream socketOutputStream = socket.getOutputStream();
                PrintWriter out = new PrintWriter(socketOutputStream,true);
        ) {
            System.out.println("Connection established.");
            String message = socketStringInputStream.readLine();
            out.write("Server says: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
