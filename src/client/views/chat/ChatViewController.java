package client.views.chat;

import client.core.ViewController;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

public class ChatViewController implements ViewController {
    @FXML private ListView<String> chatView;
    @FXML private TextField message;
    @FXML private Label user;
    @FXML private Text onlineUsers;
    private ViewHandler vh;
    private ChatViewModel viewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        this.viewModel = vmf.getChatViewModel();
        viewModel.fetchNumberOfOnlineUsers();
        viewModel.bindChat(chatView.itemsProperty());
        viewModel.bindMessage(message.textProperty());
        viewModel.bindUser(user.textProperty());
        viewModel.bindOnlineUsers(onlineUsers.textProperty());
    }
    @FXML protected void viewLogButtonPressed()
    {
       vh.openLog();
    }
    @FXML protected void sendButtonPressed()
    {
        viewModel.send();
    }

    public void openSignUp() {
        vh.openSignUp();
    }
}
