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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void leerUsuarios() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("C:\\Users\\dam2_alu07\\Documents\\AccesoDatos\\productos.bin")))){
            HashMap<String,User> listaUsers = (HashMap) ois.readObject();

            for (User usuario: listaUsers.values()) {
                Users.addUser(usuario);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
