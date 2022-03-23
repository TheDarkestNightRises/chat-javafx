package client.model;

import client.network.Client;

import java.beans.PropertyChangeListener;

public class ChatManagerImplementation implements ChatManager {
    private Client client;
    public ChatManagerImplementation(Client client) {
        this.client = client;
        client.startClient();
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {

    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {

    }
}
