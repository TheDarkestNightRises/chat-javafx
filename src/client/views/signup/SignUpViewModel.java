package client.views.signup;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class SignUpViewModel {
    private final UserModel model;
    private final StringProperty username;
    private final StringProperty password;
    private final StringProperty email;

    public SignUpViewModel(UserModel model){
        this.model = model;
        this.username = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");
        this.email = new SimpleStringProperty("");
    }
    public boolean createUser(){
        try{
            addUser(username.get(), password.get(), email.get());
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
    public void bindEmail(StringProperty property){
        email.bindBidirectional(property);
    }
    public void reset(){
        username.set("");
        password.set("");
        email.set("");
    }
}
