package chat.client.views.login;

import chat.client.core.ViewController;
import chat.client.core.ViewHandler;
import chat.client.core.ViewModelFactory;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginMainController implements ViewController
{
  public TextField username;
  public PasswordField password;
  public Button signIn;
  public Button signUp;
  private ViewHandler viewHandler;
  private LoginMainViewModel viewModel;

  @Override 
  public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.viewHandler = vh;
    this.viewModel = vmf.getLoginMainViewModel();
    username.textProperty().bindBidirectional(viewModel.usernameProperty());
    password.textProperty().bindBidirectional(viewModel.passwordProperty());
  }



  public void signInButtonPressed()
  {
    boolean isSignedIn = viewModel.signIn();
    if (isSignedIn) {
      viewModel.setUser();
      viewHandler.openChat();
    }
  }

  public void signUpButtonPressed()
  {
    viewHandler.openSignUp();
  }


}

