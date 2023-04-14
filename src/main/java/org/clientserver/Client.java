package org.clientserver;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        // get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();

        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        int i = 0;
        while(true) {

            // establish socket connection to server
            socket = new Socket(host.getHostName(), 9876);

            // write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket Server");

            if (i == 1000) {
                oos.writeObject("exit");
                break;
            }

            oos.writeObject("Request: " + i);
            i++;

            // read the server response message
            ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message: " + message);

            // close resources
            ois.close();
            oos.close();

            System.out.format("Tick: %d\n", System.nanoTime());
            Thread.sleep(1000);
        }
    }

}
