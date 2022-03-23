package client.views.chat;

import client.core.ViewController;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class ChatViewController implements ViewController {
    @FXML private ListView<String> chatView;
    @FXML private TextField message;
    private ViewHandler vh;
    private ChatViewModel viewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        this.viewModel = vmf.getChatViewModel();
        //bind
    }
    @FXML protected void viewLogButtonPressed()
    {

    }
    @FXML protected void sendButtonPressed()
    {

    }
}
