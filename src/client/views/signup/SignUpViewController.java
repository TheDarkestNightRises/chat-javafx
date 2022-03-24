package client.views.signup;

import client.core.ViewController;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;


public class SignUpViewController implements ViewController {
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private Button signUpButton;
    private ViewHandler viewHandler;
    private SignUpViewModel viewModel;
    private static Region root;

    @FXML
    public void submitUsername() {
        password.requestFocus();
    }

    @FXML
    public void submitEmail() {
        email.requestFocus();
    }

    @FXML
    public void submitPassword() {
        signUpButtonPressed();
    }

    @FXML
    protected void signUpButtonPressed() {
        viewModel.createUser();
    }



    public static Region getRoot() {
        return root;
    }


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        viewHandler = vh;
        viewModel = vmf.getSignUpViewModel();
    }
}

