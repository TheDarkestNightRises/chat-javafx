package client.views.login;

import client.core.ViewController;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.event.ActionEvent;
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
  private LoginMainViewModel LoginMainViewModel;

  @Override 
  public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.viewHandler = vh;
    this.LoginMainViewModel = vmf.getLoginMainViewModel();
  }

  public void usernameTyped()
  {
  }

  public void passwordTyped()
  {
  }

  public void signInButtonPressed()
  {
  }

  public void signUpButtonPressed()
  {
  }


}

