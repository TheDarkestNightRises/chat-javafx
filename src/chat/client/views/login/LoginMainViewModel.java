package chat.client.views.login;

import chat.client.model.ChatManager;
import chat.client.model.User;
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
    return chatManager.signIn(username.get(),password.get());
  }


  public StringProperty usernameProperty()
  {
    return username;
  }


  public StringProperty passwordProperty()
  {
    return password;
  }

  public void setUser()
  {
    chatManager.setUser(new User(username.get(),password.get()));
  }
}