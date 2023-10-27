package model;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZIP {
 public void exportarZip(String exportarZip, File fileToZip){
     System.out.println("mostrando metodo pruebaZip");
     try {
         FileOutputStream fos = new FileOutputStream(exportarZip);
         ZipOutputStream zipOut = new ZipOutputStream(fos);

         FileInputStream fis = new FileInputStream(fileToZip);
         ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
         zipOut.putNextEntry(zipEntry);

         byte[] bytes = new byte[1024];
         int length;
         while((length = fis.read(bytes)) >= 0) {
             zipOut.write(bytes, 0, length);
         }

         zipOut.close();
         fis.close();
         fos.close();

         System.out.println("Compresión finalizada!");
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
}
