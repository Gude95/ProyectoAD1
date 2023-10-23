package model;

import gui.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class App {
    private final String filename = "usuarios.bin";
    private Users users;
    private Session session;

    private FileHandler fileHander;


    public App() {
        this.fileHander = new FileHandler(this.filename);
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

    public void createUser(String username, String password, int age, String mail) {
        users.addUser(new User(username,password,age,mail));
        fileHander.almacenarUsuarios(users);
        System.out.println("Usuario " + username + " creado correctamente.");
    }
}
