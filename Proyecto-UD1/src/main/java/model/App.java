package model;

import java.io.File;

public class App {
    private final String filename = "usuarios.bin";
    private Users users;
    private Session session;
    private FileHandler fileHander;

    private XML xml;


    public App() {
        this.fileHander = new FileHandler(this.filename);
        this.users =fileHander.leerUsuarios();
        this.session = new Session();
        this.xml = new XML();
    }

    public String getFilename() {
        return filename;
    }

    public XML getXml() {
        return xml;
    }

    public Users getUsers() {
        return users;
    }

    public FileHandler getFileHander() {
        return fileHander;
    }

    public boolean login(String username, String password) {
        User user = users.getUser(username);
        if(user == null) {
            return false;
        }
        return user.checkPassword(password);
    }

    public Session getSession() {
        return session;
    }

    public void zip(String nombreExportar, File filetozip) {
        ZIP  zip = new ZIP();
        zip.exportarZip(nombreExportar, filetozip);
    }

    public void createUser(String username, String password, int age, String mail) {
        users.addUser(new User(username,password,age,mail));
        fileHander.almacenarUsuarios(users);
        System.out.println("Usuario " + username + " creado correctamente.");
    }

    public void deleteUser(String username){
        User user = users.getUser(username);
        users.getUsers().remove(username);
        System.out.println(username + " ha sido borrado");
    }

    public void changePassword(String username,String newPassword){
        User user = users.getUser(username);
        user.setPassword(newPassword);
    }

}
