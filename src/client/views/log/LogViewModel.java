package client.views.log;

import client.model.ChatManager;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.LogEntry;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class LogViewModel
{

  private ObservableList<LogEntry> logItems;
  private ChatManager chatManager;
  private StringProperty IP;
  private StringProperty date;
  private StringProperty time;
  private StringProperty text;

  public LogViewModel(ChatManager chatManager)
  {

    this.logItems = new SimpleListProperty<>(FXCollections.observableArrayList());
    this.chatManager = chatManager;
    chatManager.addListener("NewLogEntry", this::onNewLogEntry);
    this.IP = new SimpleStringProperty("");
    this.date = new SimpleStringProperty("");
    this.time = new SimpleStringProperty("");
    this.text = new SimpleStringProperty("");
  }

  private void onNewLogEntry(PropertyChangeEvent evt) {
    logItems.add((LogEntry)evt.getNewValue());

  }

  void loadLogs() {
    List<LogEntry> logList = chatManager.getLog();
    logItems = FXCollections.observableArrayList(logList);
  }




  ObservableList<LogEntry> getLogs() {
    return logItems;
  }

}

