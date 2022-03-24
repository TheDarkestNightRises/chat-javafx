package client.views.login;

import client.model.ChatManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginMainViewModel {

  private ChatManager chatManager;
  private StringProperty username;
  private StringProperty password;

  public LoginMainViewModel(ChatManager chatManager)
  {
    this.chatManager = chatManager;
    this.username = new SimpleStringProperty("");
    this.password = new SimpleStringProperty("");
  }

  public boolean signIn()
  {
    reset();
    return chatManager.signIn(username.get(),password.get());
  }

  private void reset()
  {
    this.username.setValue("");
    this.password.setValue("");
  }

  public StringProperty usernameProperty()
  {
    return username;
  }


  public StringProperty passwordProperty()
  {
    return password;
  }
}