package chat.client.network;

import chat.shared.LogEntry;
import chat.shared.Message;
import chat.util.Subject;

import java.util.List;

public interface Client extends Subject {
    void startClient();
    void addUser(String username, String password);
    List<LogEntry> getLog();
    boolean signIn(String username, String password);
  void sendMessage(Message message);
  String getIp();
  int getNumberOfUsers();
}
