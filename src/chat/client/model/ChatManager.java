package chat.client.model;

import chat.shared.LogEntry;
import chat.util.Subject;

import java.util.List;

public interface ChatManager extends Subject {
    void addUser(String username, String password);
    List<LogEntry> getLog();
    boolean signIn(String username, String password);

    void setUser(User user);
    void sendMessage(String messageBody);
    String getUser();
    int getNumberOfUsers();
}
