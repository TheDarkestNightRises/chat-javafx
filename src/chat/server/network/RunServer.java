package chat.server.network;

import chat.server.model.ServerChatManagerImplementation;

public class RunServer {
    public static void main(String[] args) {
        SocketServer server = new SocketServer(new ServerChatManagerImplementation());
        server.startServer();
    }
}
