package model;

import gui.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class App {
    private final String filename = "usuarios.bin";
    private Users users;
    private Session session;


    public App() {
        FileHandler fileHander = new FileHandler(this.filename);
        this.users =fileHander.leerUsuarios();
       // fileHander.almacenarUsuarios(this.users.getUsers());
        this.session = new Session();


    }


    public Session getSession() {
        return session;
    }

    public boolean login(String username, String password) {
        User user = users.getUser(username);
        if(user == null) {
            return false;
        }
        return user.checkPassword(password);
    }

}
