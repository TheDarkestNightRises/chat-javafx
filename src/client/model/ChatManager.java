package client.model;

import util.Subject;

public interface ChatManager extends Subject {
    void addUser(String username, String password, String email);
}
