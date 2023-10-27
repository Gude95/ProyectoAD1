package model;

import java.io.Serializable;
import java.util.HashMap;

public class Users implements Serializable {
    private HashMap<String, User> users;

    public Users() {
        this.users = new HashMap<>();
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public  void addUser(User usuario) {
        users.put(usuario.getName(),usuario);
    }

    public User getUser(String user) {
        return users.get(user);
    }
}
