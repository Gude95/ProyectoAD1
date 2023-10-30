package model;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZIP {
 public void exportarZip(String exportarZip, File fileToZip, File fileXML, File fileJSON){
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
         fis.close();

         // Comprimir fileXML
         fis = new FileInputStream(fileXML);
         zipEntry = new ZipEntry(fileXML.getName());
         zipOut.putNextEntry(zipEntry);

         while ((length = fis.read(bytes)) >= 0) {
             zipOut.write(bytes, 0, length);
         }
         fis.close();

         // Comprimir fileJSON
         fis = new FileInputStream(fileJSON);
         zipEntry = new ZipEntry(fileJSON.getName());
         zipOut.putNextEntry(zipEntry);

         while ((length = fis.read(bytes)) >= 0) {
             zipOut.write(bytes, 0, length);
         }
         fis.close();


            zipOut.close();
         fos.close();

         System.out.println("Compresión finalizada!");
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
}
