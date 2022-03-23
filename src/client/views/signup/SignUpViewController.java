package client.views.signup;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewmodel.SignUpViewModel;

public class SignUpViewController {
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
        boolean success = viewModel.createUser();
        if (success) {
            viewHandler.openView(ViewHandler.CREATE);
        }
    }

    public void init(ViewHandler viewHandler, SignUpViewModel signUpViewModel, Region region) {
        this.viewHandler = viewHandler;
        this.viewModel = signUpViewModel;
        this.root = root;

        signUpViewModel.bindUsername(username.textProperty());
        signUpViewModel.bindPassword(password.textProperty());
        signUpViewModel.bindEmail(email.textProperty());
    }

    public static Region getRoot() {
        return root;
    }


}

