package client.model;

import client.network.Client;
import shared.LogEntry;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class ChatManagerImplementation implements ChatManager {

    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private Client client;
    public ChatManagerImplementation(Client client) {
        this.client = client;
        client.startClient();
        client.addListener("NewLogEntry", this::onNewLogEntry);
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
    client.signIn(username,password);
    return false;
  }

  @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
   support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }

    @Override
    public void addUser(String username, String password, String email) {
        client.addUser(username, password, email);
    }


}
