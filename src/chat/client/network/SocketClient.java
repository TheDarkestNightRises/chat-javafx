package chat.client.network;

import chat.shared.LogEntry;
import chat.client.model.User;
import chat.shared.Message;
import chat.shared.Request;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class SocketClient implements Client
{
  private PropertyChangeSupport support;
  private String ip;

  public SocketClient()
  {
    this.support = new PropertyChangeSupport(this);
  }

  public void startClient()
  {
    try
    {
      Socket socket = new Socket("localhost", 6969);
      ip = socket.getRemoteSocketAddress().toString();
      ObjectOutputStream outToServer = new ObjectOutputStream(
          socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(
          socket.getInputStream());

      new Thread(() -> listenToServer(outToServer, inFromServer)).start();

    }
    catch (IOException e)
    {
      e.printStackTrace();

    }
  }

  private void listenToServer(ObjectOutputStream outToServer,
      ObjectInputStream inFromServer)
  {
    try
    {
      outToServer.writeObject(new Request("Listener", null));
      while (true)
      {
        Request response = (Request) inFromServer.readObject();
        System.out.println(response.getArg());
        support.firePropertyChange(response.getType(), null, response.getArg());
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }

  }

  @Override public void addUser(String username, String password)
  {
    Request request = new Request("UserAdded", new User(username, password));
    try
    {
      Socket socket = new Socket("localhost", 6969);
      ObjectOutputStream outToServer = new ObjectOutputStream(
          socket.getOutputStream());
      outToServer.writeObject(request);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public List<LogEntry> getLog()
  {
    try
    {
      Request response = request(null, "FetchLog");
      return (List<LogEntry>) response.getArg();
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public boolean signIn(String username, String password)
  {
    try
    {
      System.out.println(username + " " + password);
      Request request = new Request("SignIn", new User(username, password));
      Socket socket = new Socket("localhost", 6969);
      ObjectOutputStream outToServer = new ObjectOutputStream(
          socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(
          socket.getInputStream());
      outToServer.writeObject(request);
      Request response = (Request) inFromServer.readObject();
      return (boolean) response.getArg();
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return false;
  }

  @Override public void sendMessage(Message message)
  {
    Request request = new Request("SendMessage", message);
    try
    {
      Socket socket = new Socket("localhost", 6969);
      ObjectOutputStream outToServer = new ObjectOutputStream(
          socket.getOutputStream());
      outToServer.writeObject(request);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public String getIp()
  {
    return ip;
  }

  @Override public int getNumberOfUsers()
  {
    try
    {
      Request response = request(null, "FetchNumberOfUsers");
      return (int) response.getArg();
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return 0;
  }

  private Request request(String arg, String type)
      throws IOException, ClassNotFoundException
  {
    Socket socket = new Socket("localhost", 6969);
    ObjectOutputStream outToServer = new ObjectOutputStream(
        socket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(
        socket.getInputStream());
    outToServer.writeObject(new Request(type, arg));
    return (Request) inFromServer.readObject();
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }

}
