package socketprogramming.simpleclientserverdemo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {

    public static void main(String[] args) {

        System.out.println("Client started.");
        try (
                // localhost or 27.0.0.1 for IPv4 or ::1 for IPv6.
                Socket socket = new Socket("localhost", 10000);

                // read data from console (user input)
                InputStream byteStream = System.in;
                InputStreamReader charStream = new InputStreamReader(byteStream);
                BufferedReader stringStream = new BufferedReader(charStream);

                // write data to socket (to communicate to server)
                OutputStream socketOutputStream = socket.getOutputStream();
                PrintWriter out = new PrintWriter(socketOutputStream, true);

                // read data from socket
                InputStream socketByteInputStream = socket.getInputStream();
                InputStreamReader socketCharInputStream = new InputStreamReader(socketByteInputStream);
                BufferedReader socketStringInputStream = new BufferedReader(socketCharInputStream);
        ) {
            System.out.println("Enter a line:");
            String message = stringStream.readLine();
            out.println(message);

            String serverMessage = socketStringInputStream.readLine();
            System.out.println(serverMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
