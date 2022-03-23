package client.views.login;

import client.core.ViewController;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;


public class LoginMainController implements ViewController {
    public Button signIn;
    public Button signUp;
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;
    private ViewHandler viewHandler;
    private static LoginMainViewModel loginMainViewModel;
    private Region root;

    @FXML
    public void usernameTyped() {
        username.requestFocus();
    }

    @FXML
    public void passwordTyped() {
        password.requestFocus();
    }

    @FXML
    public void signInButtonPressed() {

    }

    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        this.loginMainViewModel = vmf.getLoginMainViewModel;


        LoginMainViewModel.bindUsername(username.textProperty());
        LoginMainViewModel.bindPassword(password.textProperty());

    }
}
