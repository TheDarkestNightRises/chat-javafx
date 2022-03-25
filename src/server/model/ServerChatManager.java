package server.model;

import client.model.User;
import shared.LogEntry;
import shared.Message;
import util.Subject;

import java.util.List;

public interface ServerChatManager extends Subject
{
    void addUser(User user);
    List<LogEntry> getLog();
  boolean isSignedIn(User user);
  void sendMessage(Message arg);
}
