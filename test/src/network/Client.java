/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

/**
 *
 * @author u55369
 */
// A Java program for a Client 
import java.net.*;
import java.io.*;

public class Client {

    // initialize socket and input output streams 
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    // constructor to put ip address and port 
    public Client(String address, int port) {
        // establish a connection 
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal 
            input = new DataInputStream(System.in);

            // sends output to the socket 
            out = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }

        // string to read message from input 
        String line = "";

        // keep reading until "Over" is input 
        while (!line.equals("Over")) {
            try {
                line = input.readLine();
                out.writeUTF(line);
            } catch (IOException i) {
                System.out.println(i);
            }
        }

        // close the connection 
        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        System.setProperty("java.net.useSystemProxies", "true");
        String host = "165.225.104.32";
        String port = "10223";

        System.setProperty(
                "http.proxyHost", host);
        System.setProperty(
                "http.proxyPort", port);
        System.setProperty(
                "https.proxyHost", host);
        System.setProperty(
                "https.proxyPort", port);

        Client client = new Client("10.100.207.67", 5001);
    }
}
