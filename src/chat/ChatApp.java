package chat;

import chat.client.core.ClientFactory;
import chat.client.core.ModelFactory;
import chat.client.core.ViewHandler;
import chat.client.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class ChatApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ClientFactory clientFactory = new ClientFactory();
        ModelFactory modelFactory = new ModelFactory(clientFactory);
        ViewModelFactory vmf = new ViewModelFactory(modelFactory);
        ViewHandler vh = new ViewHandler(vmf);
        vh.start();
    }
}
