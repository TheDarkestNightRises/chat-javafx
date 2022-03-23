package client.views.log;

import client.core.ViewController;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class LogViewController implements ViewController {

    @FXML private ListView<String> log;
    private ViewHandler viewHandler;
    private LogViewModel logViewModel;

  @FXML
  public void back() {
    viewHandler.openChat();
  }

  @Override
  public void init(ViewHandler vh, ViewModelFactory vmf) {
    viewHandler = vh;
    logViewModel = vmf.getLogViewModel();
    logViewModel.bindMessage(log.itemsProperty());
  }

}
