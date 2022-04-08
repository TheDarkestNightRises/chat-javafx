package chat.client.core;

import chat.client.views.chat.ChatViewModel;
import chat.client.views.log.LogViewModel;
import chat.client.views.login.LoginMainViewModel;
import chat.client.views.signup.SignUpViewModel;


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
