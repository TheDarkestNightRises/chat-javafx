package chat.server.model;

import chat.client.model.User;
import chat.shared.LogEntry;
import chat.shared.Message;
import chat.util.Subject;

import java.util.List;

public interface ServerChatManager extends Subject
{
    void addUser(User user);
    List<LogEntry> getLog();
  boolean isSignedIn(User user);
  void sendMessage(Message arg);
  int getNumberOfUsers();
}
