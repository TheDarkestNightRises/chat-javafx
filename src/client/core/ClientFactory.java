package client.core;

import client.network.Client;
import client.network.SocketClient;

public class ClientFactory {
    private Client client;

    public Client getClient() {
        if (client == null) {
            this.client = new SocketClient();
        }
        return client;
    }
}
