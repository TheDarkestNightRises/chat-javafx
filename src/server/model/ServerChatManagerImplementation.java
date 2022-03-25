package server.model;

import client.model.User;
import shared.LogEntry;
import shared.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ServerChatManagerImplementation implements ServerChatManager
{
  private List<User> userList;
  private PropertyChangeSupport support;
  private List<LogEntry> logEntries;

  public ServerChatManagerImplementation()
  {
    this.userList = new ArrayList<>();
    support = new PropertyChangeSupport(this);
    logEntries = new ArrayList<>();
  }

  @Override public void addUser(User user)
  {
    int oldValue = userList.size();
    userList.add(user);
    System.out.println(userList);
    support.firePropertyChange("OnNewUserEntry",oldValue,userList.size());
  }

  // the actual method to get all the data into the log


  @Override public List<LogEntry> getLog()
  {
    return new ArrayList<>(logEntries);
  }

  @Override public boolean isSignedIn(User user)
  {
    System.out.println(user);
    boolean result = false;
    for (User currentUser : userList)
    {
      if (currentUser.equals(user))
      {
        result = true;
        break;
      }
    }
    System.out.println(result);
    return result;
  }

  @Override public void sendMessage(Message arg)
  {
    LogEntry logEntry = new LogEntry(arg.getMessage(), arg.getIp(),arg.getDate(),arg.getTime());
    logEntries.add(logEntry);
    support.firePropertyChange("NewLogEntry",null,logEntry);
  }

  @Override public int getNumberOfUsers()
  {
    return userList.size();
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName,listener);
  }
}
