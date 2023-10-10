package model;

import java.util.HashMap;
import java.util.Map;

public class Users {
    static HashMap<String, User> users = new HashMap<>();

    public static void addUser(User usuario) {
        users.put(usuario.getName(),usuario);
    }
}
