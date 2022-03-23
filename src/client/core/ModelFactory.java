package client.core;

import client.model.ChatManager;
import client.model.ChatManagerImplementation;

public class ModelFactory {
    private ChatManager chatManager;
    private ClientFactory clientFactory;

    public ModelFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    public ChatManager getChatManager() {
        if(chatManager == null)
            chatManager = new ChatManagerImplementation(clientFactory.getClient());
        return chatManager;
    }


}
