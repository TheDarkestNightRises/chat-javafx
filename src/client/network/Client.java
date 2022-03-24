package client.network;

import shared.LogEntry;
import util.Subject;

import java.util.List;

public interface Client extends Subject {
    void startClient();
    void addUser(String username, String password, String email);
    List<LogEntry> getLog();
    boolean signIn(String username, String password);
}
