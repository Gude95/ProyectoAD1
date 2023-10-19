package model;

import java.util.HashMap;
import java.util.Map;

public class Users {
    private HashMap<String, User> users = new HashMap<>();

    public Users() {
        User user = new User("admin","admin", 0, "admin@admin.local");
        users.put(user.getName(),user);
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }

    public static void addUser(User usuario) {

    }
}
