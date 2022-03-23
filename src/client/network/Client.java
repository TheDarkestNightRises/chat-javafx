package client.network;

import util.Subject;

public interface Client extends Subject {
    void startClient();
    void addUser(String username, String password, String email);
}
