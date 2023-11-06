package model;

import java.io.*;

public class FileHandler {
    private File file ;
   private byte[] cabecera = {(byte)0xFF, (byte)0xEE, 0x20, 0x23, (byte)0xEE , (byte)0xFF};

    public FileHandler(String path) {
        this.file= new File(path);
    }

    public void almacenarUsuarios(Users users) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            fos.write(cabecera);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (ObjectOutputStream out = new ObjectOutputStream(fos)){
            out.writeObject(users);
            System.out.println("usuarios almacenados en " + file.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public  Users leerUsuarios() {
        Users users = new Users();
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            boolean extension = ComprobarBytes(cabecera,fis);
            if (extension) {
                System.out.println("cabecera correcta!");
            } else {
                System.err.println("cabecera incorrecta!");
            }
            try (ObjectInputStream ois = new ObjectInputStream(fis)){
                users = (Users) ois.readObject();
                User user = users.getUser("admin");
                if (user==null){
                    user = new User("admin", "admin", 0, "admin@admin.local");
                    users.addUser(user);
                    almacenarUsuarios(users);
                }

                System.out.println("usuarios obtenidos");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }  catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
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
        }
        return users;
    }

    public static boolean ComprobarBytes ( byte[] magicNumbers, FileInputStream fis) {
        boolean extesiontrue = true;
        try {
            for (int i= 0; i<magicNumbers.length;i++){
                byte b = (byte)fis.read();
                if(b!=magicNumbers[i]){
                    extesiontrue = false;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return extesiontrue;
    }


}
