package chat.client.core;

import chat.client.model.ChatManager;
import chat.client.model.ChatManagerImplementation;

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
