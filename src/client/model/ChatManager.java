package client.model;

import shared.LogEntry;
import util.Subject;

import java.util.List;

public interface ChatManager extends Subject {
    void addUser(String username, String password, String email);
    List<LogEntry> getLog();
}
