package server.model;

import client.model.User;

import java.util.ArrayList;
import java.util.List;

public class ServerChatManagerImplementation implements ServerChatManager{
    private List<User> userList;

    public ServerChatManagerImplementation() {
        this.userList = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        userList.add(user);
        System.out.println(userList);
    }
}
