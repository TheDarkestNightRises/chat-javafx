package client.network;

import client.model.User;
import shared.Request;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClient implements Client{
    private PropertyChangeSupport support;

    public SocketClient() {
        this.support = new PropertyChangeSupport(this);
    }

    public void startClient() {
        try {
            Socket socket = new Socket("localhost",6969);
            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUser(String username, String password, String email) {
        Request request = new Request("UserAdded",new User(username,password,email));
        try {
            Socket socket = new Socket("localhost",6969);
            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            outToServer.writeObject(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {

    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {

    }
}
