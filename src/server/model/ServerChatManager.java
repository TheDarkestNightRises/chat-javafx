package server.model;

import client.model.User;
import shared.LogEntry;

import java.util.List;

public interface ServerChatManager {
    void addUser(User user);
    List<LogEntry> getLog();
}
