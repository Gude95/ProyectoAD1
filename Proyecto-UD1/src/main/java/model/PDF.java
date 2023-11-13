package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PDF {

    public void generarPDF (File file, String nombre, String edad, String email){
        System.out.println("pdf");

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            bw.write(nombre);
            bw.newLine();
            bw.write(edad);
            bw.newLine();
            bw.write(email);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
