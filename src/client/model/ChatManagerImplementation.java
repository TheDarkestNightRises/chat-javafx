package client.model;

import client.network.Client;
import shared.LogEntry;
import shared.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class ChatManagerImplementation implements ChatManager
{

  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private Client client;
  private User user;

  public ChatManagerImplementation(Client client)
  {
    this.client = client;
    client.startClient();
    client.addListener("NewLogEntry", this::onNewLogEntry);
    client.addListener("MessageAdded", this::onNewMessage);
    client.addListener("OnNewUserEntry", this::onNewUserEntry);
  }

  private void onNewUserEntry(PropertyChangeEvent propertyChangeEvent)
  {
    support.firePropertyChange(propertyChangeEvent);
  }

  private void onNewMessage(PropertyChangeEvent propertyChangeEvent)
  {
    support.firePropertyChange(propertyChangeEvent);
  }

  private void onNewLogEntry(PropertyChangeEvent evt)
  {

    support.firePropertyChange(evt);
  }

  @Override public List<LogEntry> getLog()
  {
    return client.getLog();
  }

  @Override public boolean signIn(String username, String password)
  {
    return client.signIn(username, password);
  }



  @Override public void addUser(String username, String password)
  {
    client.addUser(username, password);
  }

  public void setUser(User user)
  {
    this.user = user;
  }

  @Override public String getUser()
  {
    return user.getUsername();
  }

  @Override public int getNumberOfUsers()
  {
    return client.getNumberOfUsers();
  }

  @Override public void sendMessage(String messageBody)
  {
   Message message = new Message(user,messageBody,client.getIp());
   client.sendMessage(message);
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
