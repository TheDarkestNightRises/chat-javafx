package client.views.login;


import client.model.ChatManager;
import client.model.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class LoginMainViewModel {
    private final User model;
    private static StringProperty username;
    private static StringProperty password;

    public LoginMainViewModel(ChatManager model) {
        this.model = (User) model;
        this.username = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");
    }

    public static void bindUsername(StringProperty property) {
        username.bindBidirectional(property);
    }

    public static void bindPassword(StringProperty property) {
        password.bindBidirectional(property);

    }

    public void reset() {
        username.set("");
        password.set("");
    }
}