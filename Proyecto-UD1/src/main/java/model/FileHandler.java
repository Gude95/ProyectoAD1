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

    public void almacenarUsuarios(HashMap mapUsers) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(mapUsers);
            System.out.println("usuarios almacenados en " + file.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public  void leerUsuarios() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            HashMap<String,User> listaUsers = (HashMap) ois.readObject();

            for (User usuario: listaUsers.values()) {
                Users users = new Users();
                users.addUser(usuario);
                System.out.println(usuario.getPasswordHash());
            }
            System.out.println("usuarios obtenidos");
        } catch (FileNotFoundException e) {
            File file = new File("usuarios.bin");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
