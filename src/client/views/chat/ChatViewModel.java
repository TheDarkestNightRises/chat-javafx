package client.views.chat;

import client.model.ChatManager;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ChatViewModel
{
  private ChatManager model;
  private SimpleListProperty<String> chat;
  private StringProperty messageBody;
  private StringProperty user;
  private StringProperty onlineUsers;

  public ChatViewModel(ChatManager chatManager)
  {
    this.model = chatManager;
    this.chat = new SimpleListProperty<>(FXCollections.observableArrayList());
    this.messageBody = new SimpleStringProperty("");
    this.user = new SimpleStringProperty(model.getUser());
    this.onlineUsers = new SimpleStringProperty("");
    model.addListener("MessageAdded", this::updateChat);
    chatManager.addListener("OnNewUserEntry", this::onNewUserEntry);

  }

  private void onNewUserEntry(PropertyChangeEvent propertyChangeEvent)
  {
    int number = (int) propertyChangeEvent.getNewValue();
    Platform.runLater(() -> onlineUsers.set("Online users: " + number));
  }

  private void updateChat(PropertyChangeEvent propertyChangeEvent)
  {
    Message message = (Message) propertyChangeEvent.getNewValue();
    Platform.runLater(() -> chat.add(String.valueOf(message)));
  }

  public void send()
  {
    model.sendMessage(messageBody.get());
  }

  public void bindChat(ObjectProperty<ObservableList<String>> property)
  {
    property.bind(chat);
  }

  public void bindMessage(StringProperty property)
  {
    property.bindBidirectional(messageBody);
  }

  public void bindUser(StringProperty property)
  {
    property.bind(user);
  }

  public void bindOnlineUsers(StringProperty textProperty)
  {
    textProperty.bindBidirectional(onlineUsers);
  }

  public void fetchNumberOfOnlineUsers()
  {
    onlineUsers.set("Online users: " + model.getNumberOfUsers());
  }
}
