package client.core;

import client.views.chat.ChatViewModel;
import client.views.log.LogViewModel;
import client.views.login.LoginMainViewModel;
import client.views.signup.SignUpViewModel;


public class ViewModelFactory {
    private ModelFactory modelFactory;
    private ChatViewModel chatViewModel;
    private LogViewModel logViewModel;
    private SignUpViewModel signUpViewModel;
    private LoginMainViewModel loginMainViewModel;


    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public ChatViewModel getChatViewModel() {
        if (chatViewModel == null)
            chatViewModel = new ChatViewModel(modelFactory.getChatManager());
        return chatViewModel;
    }

    public LogViewModel getLogViewModel() {
        if (logViewModel == null)
            logViewModel = new LogViewModel(modelFactory.getChatManager());
        return logViewModel;
    }

    public SignUpViewModel getSignUpViewModel() {
        if (signUpViewModel == null)
            signUpViewModel = new SignUpViewModel(modelFactory.getChatManager());
        return signUpViewModel;
    }

  public LoginMainViewModel getLoginMainViewModel()
  {
      if (loginMainViewModel == null)
          loginMainViewModel = new LoginMainViewModel(modelFactory.getChatManager());
      return loginMainViewModel;
  }
}
