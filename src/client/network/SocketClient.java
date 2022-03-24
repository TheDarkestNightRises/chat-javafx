package client.network;

import shared.LogEntry;
import client.model.User;
import shared.Request;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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

            new Thread(()-> listenToServer(outToServer, inFromServer)).start();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void listenToServer(ObjectOutputStream outToServer,
        ObjectInputStream inFromServer)
    {
        while (true)
        {
            try
            {
                Request request = (Request) inFromServer.readObject();
                support.firePropertyChange(request.getType(),null,request.getArg());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
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


  //the actual method to add date to the log

    @Override
    public List<LogEntry> getLog() {
        try {
            Request response = request(null, "FetchLog");
            return (List<LogEntry>) response.getArg();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override public boolean signIn(String username, String password)
    {
        try
        {
            Request request = new Request("SignIn",new User("",username,password));
            Socket socket = new Socket("localhost",6969);
            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
            outToServer.writeObject(request);
            Request response = (Request) inFromServer.readObject();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    private Request request(String arg, String type) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 6969);
        ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
        outToServer.writeObject(new Request(type, arg));
        return (Request) inFromServer.readObject();
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {

    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {

    }
}
