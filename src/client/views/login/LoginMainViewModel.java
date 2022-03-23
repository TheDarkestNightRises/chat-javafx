package client.views.login;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.UserModel;

public class LoginMainViewModel {
    private final UserModel model;
    private static StringProperty username;
    private static StringProperty password;

    public LoginMainViewModel(UserModel model) {
        this.model = model;
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