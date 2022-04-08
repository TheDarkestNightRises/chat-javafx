package chat.client.core;

import chat.client.network.Client;
import chat.client.network.SocketClient;

public class ClientFactory {
    private Client client;

    public Client getClient() {
        if (client == null) {
            this.client = new SocketClient();
        }
        return client;
    }
}
