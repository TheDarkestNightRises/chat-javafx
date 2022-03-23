package server.network;

import server.model.ServerChatManager;
import server.model.ServerChatManagerImplementation;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    private ServerChatManager serverChatManager;

    public SocketServer(ServerChatManager serverChatManagerImplementation) {
        this.serverChatManager = serverChatManagerImplementation;
    }

    public void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(6969);
            System.out.println("Server started...");
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new SocketHandler(socket,serverChatManager)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
