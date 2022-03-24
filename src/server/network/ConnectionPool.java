package server.network;

import shared.Message;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private List<SocketHandler> conns = new ArrayList<>();

    public void addConnection(SocketHandler socketHandler) {
        conns.add(socketHandler);
    }

    public void broadcast(Message message) {
        for (SocketHandler conn : conns) {
                conn.sendMessageToClient(message);
            }
    }

    public void removeConnection(SocketHandler socketHandler) {
        conns.remove(socketHandler);
    }
}
