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

public class LogViewModel implements PropertyChangeListener
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

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    //
  }

  public void bindItems(ObjectProperty<ObservableList<LogEntry>> property)
  {
   property.bind(
       (ObservableValue<? extends ObservableList<LogEntry>>) logItems);
  }

  ObservableList<LogEntry> getLogs() {
    return logItems;
  }
  public void bindIP(StringProperty property)
  {
    property.bind(IP);
  }
  public void bindDate(StringProperty property)
  {
    property.bind(date);
  }
  public void bindTime(StringProperty property)
  {
    property.bind(time);
  }
  public void bindText(StringProperty property)
  {
    property.bind(text);
  }

}

