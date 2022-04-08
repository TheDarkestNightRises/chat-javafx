package chat.client.views.signup;

import chat.client.core.ViewController;
import chat.client.core.ViewHandler;
import chat.client.core.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;


public class SignUpViewController implements ViewController {
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;

    private ViewHandler viewHandler;
    private SignUpViewModel viewModel;
    private static Region root;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        viewHandler = vh;
        viewModel = vmf.getSignUpViewModel();
        viewModel.bindPassword(password.textProperty());
        viewModel.bindUsername(username.textProperty());
    }

    @FXML
    public void submitUsername() {
        password.requestFocus();
    }


    @FXML
    public void submitPassword() {
        signUpButtonPressed();
    }

    @FXML
    protected void signUpButtonPressed() {
        viewModel.createUser();
        viewHandler.openLogin();
    }

}

