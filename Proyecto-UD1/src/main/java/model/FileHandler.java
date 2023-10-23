package model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class FileHandler {
    private File file ;

    public FileHandler(String path) {
        this.file= new File(path);
    }

    public void almacenarUsuarios(Users users) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(users);
            System.out.println("usuarios almacenados en " + file.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public  Users leerUsuarios() {
        Users users = new Users();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            users = (Users) ois.readObject();
            System.out.println("usuarios obtenidos" + users.getUsers());

        } catch (FileNotFoundException e) {
            try {
                File file = new File("usuarios.bin");
                file.createNewFile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            User user = new User("admin", "admin", 0, "admin@admin.local");
            users.addUser(user);
            almacenarUsuarios(users);
            return users;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }  catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return users;
    }


}
