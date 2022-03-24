package server.model;

import client.model.User;
import shared.LogEntry;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ServerChatManagerImplementation implements ServerChatManager{
    private List<User> userList;
  private PropertyChangeSupport support;
  private List<LogEntry> logEntries;

    public ServerChatManagerImplementation() {
        this.userList = new ArrayList<>();
      support = new PropertyChangeSupport(this);
      logEntries = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        userList.add(user);
        System.out.println(userList);
    }

 // the actual method to get all the date into the log

  @Override public List<LogEntry> getLog()
  {
    return new ArrayList<>(logEntries);
  }


}
