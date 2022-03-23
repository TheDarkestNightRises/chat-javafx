package client.views.log;

import client.model.ChatManager;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LogViewModel
{

  private ChatManager model;
  private SimpleListProperty<String> logItems;

  public LogViewModel(ChatManager chatManager)
  {
    this.model = chatManager;
    this.logItems = new SimpleListProperty<>(FXCollections.observableArrayList());
  }


  public void bindMessage(ObjectProperty<ObservableList<String>> property) {
    property.bind(logItems);
  }
}

