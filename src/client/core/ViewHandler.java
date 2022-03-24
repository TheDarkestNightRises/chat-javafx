package client.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

    private Scene chatScene;
    private Stage stage;
    private ViewModelFactory vmf;

    public ViewHandler(ViewModelFactory vmf) {
        this.vmf = vmf;
    }

    public void start() {
        stage = new Stage();
        openChat();
    }

    public void openChat() {
        if (chatScene == null) {
            try {
                Parent root = loadFXML("../views/chat/ChatView.fxml");
                stage.setTitle("Chat");
                chatScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(chatScene);
        stage.show();
    }

    public void openLog() {
        try {
            Parent root = loadFXML("../views/log/Log.fxml");
            Scene logScene = new Scene(root);
            stage.setTitle("Log");
            stage.setScene(logScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openLogin(){
        try {
            Parent root = loadFXML("client/views/login/LoginMain.fxml");
            Scene loginScene = new Scene(root);
            stage.setTitle("Login");
           // stage = new Scene(loginScene);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openSignUp(){
        try {
            Parent root = loadFXML("../views/signup/SignUpView.fxml");
            Scene signUp = new Scene(root);
            stage.setTitle("Sign Up");
            stage.setScene(signUp);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    private Parent loadFXML(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();
        ViewController ctrl = loader.getController();
        ctrl.init(this, vmf);
        return root;
    }
}

