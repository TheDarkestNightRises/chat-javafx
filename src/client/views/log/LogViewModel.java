package client.views.log;

import client.model.ChatManager;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LogViewModel implements PropertyChangeListener
{

  private ChatManager model;
  private SimpleListProperty<String> logItems;

  public LogViewModel(ChatManager chatManager)
  {
    this.model = chatManager;
    this.logItems = new SimpleListProperty<>(FXCollections.observableArrayList());
  }

  public void updateLog()
  {
  //  logItems.setAll(model.history)//
  }


  public void bindItems(ObjectProperty<ObservableList<String>> property) {
    property.bind(logItems);
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    updateLog();
  }
}

