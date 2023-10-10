package model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FileHandler {
    private static File file = new File("C:\\Users\\dam2_alu07\\Documents\\AccesoDatos\\usuarios.bin");

    public static void almacenarUsuarios(HashMap mapUsers) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(mapUsers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
