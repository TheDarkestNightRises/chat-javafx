package chat.server.network;

import chat.client.model.User;
import chat.server.model.ServerChatManager;
import chat.shared.LogEntry;
import chat.shared.Message;
import chat.shared.Request;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class SocketHandler implements Runnable
{
  private final Socket socket;
  private final ServerChatManager serverChatManager;
  private final ConnectionPool connectionPool;
  private ObjectOutputStream outToClient;
  private ObjectInputStream inFromClient;

  public SocketHandler(Socket socket, ServerChatManager serverChatManager,
      ConnectionPool connectionPool)
  {
    this.connectionPool = connectionPool;
    this.socket = socket;
    this.serverChatManager = serverChatManager;
    try
    {
      outToClient = new ObjectOutputStream(socket.getOutputStream());
      inFromClient = new ObjectInputStream(socket.getInputStream());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void run()
  {
    try
    {
      Request request = (Request) inFromClient.readObject();
      if ("Listener".equals(request.getType()))
      {
        serverChatManager.addListener("NewLogEntry", this::onNewLogEntry);
        serverChatManager.addListener("OnNewUserEntry", this::onNewUserEntry);
      }
      if ("UserAdded".equals(request.getType()))
      {
        serverChatManager.addUser((User) request.getArg());
      }
      else if ("FetchLog".equals(request.getType()))
      {
        List<LogEntry> log = serverChatManager.getLog();
        outToClient.writeObject(new Request("FetchLog", log));
      }
      else if ("FetchNumberOfUsers".equals(request.getType()))
      {
        int numberOfUsers = serverChatManager.getNumberOfUsers();
        outToClient.writeObject(
            new Request("FetchNumberOfUsers", numberOfUsers));
      }
      else if ("SignIn".equals(request.getType()))
      {
        boolean state = serverChatManager.isSignedIn((User) request.getArg());
        outToClient.writeObject(new Request("SignIn", state));
      }
      else if ("SendMessage".equals(request.getType()))
      {
        serverChatManager.sendMessage((Message) request.getArg());
        connectionPool.broadcast((Message) request.getArg());
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  private void onNewUserEntry(PropertyChangeEvent propertyChangeEvent)
  {
    try
    {
      outToClient.writeObject(new Request(propertyChangeEvent.getPropertyName(),
          propertyChangeEvent.getNewValue()));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void onNewLogEntry(PropertyChangeEvent propertyChangeEvent)
  {
    try
    {
      outToClient.writeObject(new Request(propertyChangeEvent.getPropertyName(),
          propertyChangeEvent.getNewValue()));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void sendMessageToClient(Message message)
  {
    try
    {
      Request request = new Request("MessageAdded", message);
      outToClient.writeObject(request);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

}
