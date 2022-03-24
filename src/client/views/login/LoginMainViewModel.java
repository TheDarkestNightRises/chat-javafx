package client.views.login;

import client.model.ChatManager;

public class LoginMainViewModel {

  public ChatManager chatManager;
  public LoginMainViewModel(ChatManager chatManager)
  {
    this.chatManager = chatManager;
  }
  
}