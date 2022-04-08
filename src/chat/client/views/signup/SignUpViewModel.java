package chat.client.views.signup;

import chat.client.model.ChatManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class SignUpViewModel {
    private final ChatManager model;
    private final StringProperty username;
    private final StringProperty password;


    public SignUpViewModel(ChatManager model){
        this.model = model;
        this.username = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");

    }
    public boolean createUser(){
        try{
            model.addUser(username.get(), password.get());
            reset();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void bindUsername(StringProperty property){
        username.bindBidirectional(property);
    }
    public void bindPassword(StringProperty property){
        password.bindBidirectional(property);
    }

    public void reset(){
        username.set("");
        password.set("");
    }

}
