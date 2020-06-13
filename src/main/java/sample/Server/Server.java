package sample.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    public static List<Client> clients;
    public static DataOutputStream dos;
    DataInputStream dis;

    Server() {

        System.out.println("Server");

        String name;
        Socket client;

        clients = new ArrayList<Client>();

        ServerSocket servSock = new ServerSocket(10001);

        while(true) {
             client = servSock.accept();
             dis = new DataInputStream(client.getInputStream());
             dos = new DataOutputStream(client.getOutputStream());
             name = dis.readUTF() ;

             Client user = new Client(name, dos, dis);
             System.out.println("Connected : " + name);
             clients.add(user);
        }
    }
}
