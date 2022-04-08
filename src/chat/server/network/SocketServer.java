package chat.server.network;

import chat.server.model.ServerChatManager;

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
            ConnectionPool pool = new ConnectionPool();
            System.out.println("Server started...");
            while (true) {
                Socket socket = serverSocket.accept();
                SocketHandler socketHandler = new SocketHandler(socket,serverChatManager,pool);
                new Thread(socketHandler).start();
                pool.addConnection(socketHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
