package server.network;

import server.model.ServerChatManagerImplementation;

public class RunServer {
    public static void main(String[] args) {
        SocketServer server = new SocketServer(new ServerChatManagerImplementation());
        server.startServer();
    }
}
