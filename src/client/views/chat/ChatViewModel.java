package client.views.chat;

import client.model.ChatManager;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ChatViewModel implements PropertyChangeListener
{
    private ChatManager model;
    private SimpleListProperty<String> chat;
    private StringProperty message;
    private StringProperty user;
    public ChatViewModel(ChatManager chatManager) {
        this.model = chatManager;
        this.chat = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.message = new SimpleStringProperty("");
        this.user = new SimpleStringProperty("");
    }
    public void updateChat()
    {

    }
    public void send()
    {

    }
    public void bindChat(ObjectProperty<ObservableList<String>> property)
    {
        property.bind(chat);
    }
    public void bindMessage(StringProperty property)
    {
        property.bindBidirectional(message);
    }
    public void bindUser(StringProperty property)
    {
        property.bind(user);
    }
    @Override public void propertyChange(PropertyChangeEvent evt)
    {
        updateChat();
    }
}
