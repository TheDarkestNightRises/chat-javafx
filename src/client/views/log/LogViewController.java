package client.views.log;

import client.core.ViewController;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.LogEntry;

public class LogViewController implements ViewController {

    @FXML private TableView<LogEntry> tableview;
    @FXML public TableColumn<String, LogEntry> IP;
    @FXML public TableColumn<String, LogEntry> date;
    @FXML public TableColumn<String, LogEntry> time;
    @FXML public TableColumn<String, LogEntry> text;

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
    logViewModel.loadLogs();
    logViewModel.bindItems(tableview.itemsProperty());
    IP.setCellValueFactory(new PropertyValueFactory<>("IP"));
    date.setCellValueFactory(new PropertyValueFactory<>("date"));
    time.setCellValueFactory(new PropertyValueFactory<>("time"));
    text.setCellValueFactory(new PropertyValueFactory<>("text"));

    logViewModel.bindIP(IP.textProperty());
    logViewModel.bindDate(date.textProperty());
    logViewModel.bindTime(time.textProperty());
    logViewModel.bindText(text.textProperty());
  }

}
