package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Users implements Serializable {
    private HashMap<String, User> users;

    public Users() {
        this.users = new HashMap<>();



    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }

    public  void addUser(User usuario) {
        users.put(usuario.getName(),usuario);
    }

    public User getUser(String user) {
        return users.get(user);
    }
}
