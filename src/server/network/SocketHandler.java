package server.network;

import client.model.User;
import server.model.ServerChatManager;
import shared.LogEntry;
import shared.Message;
import shared.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class SocketHandler implements Runnable{
    private final Socket socket;
    private final ServerChatManager serverChatManager;
    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;

    public SocketHandler(Socket socket, ServerChatManager serverChatManager) {
        this.socket = socket;
        this.serverChatManager = serverChatManager;
        try {
            outToClient = new ObjectOutputStream(socket.getOutputStream());
            inFromClient = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Request request = (Request) inFromClient.readObject();
            if("UserAdded".equals(request.getType())) {
                serverChatManager.addUser((User) request.getArg());
            } else if("FetchLog".equals(request.getType())){
                List<LogEntry> log = serverChatManager.getLog();
                outToClient.writeObject(new Request("FetchLog",log));
            } else if("SignIn".equals(request.getType())) {
               boolean state = serverChatManager.isSignedIn((User) request.getArg());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void sendMessageToClient(Message message) {
        try {
            outToClient.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
