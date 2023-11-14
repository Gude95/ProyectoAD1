package model;


import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDF {

    public void generarPDF (File file, String nombre, String edad, String email){
        System.out.println("pdf");

        try{
            PDDocument documento = new PDDocument();
            PDPage pagina = new PDPage();
            documento.addPage(pagina);

            PDPageContentStream contenido = new PDPageContentStream(documento, pagina);


            contenido.beginText();
            contenido.newLineAtOffset(50, 700);
            contenido.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contenido.showText("Nombre: " + nombre);
            contenido.newLineAtOffset(0, -20);
            contenido.showText("Edad: " + edad);
            contenido.newLineAtOffset(0, -20);
            contenido.showText("Correo electronico: " + email);
            contenido.endText();


            contenido.close();
            documento.save(file);
            documento.close();

            System.out.println("PDF exportado exitosamente a: " + file);


        } catch (IOException e) {
                e.getMessage();        }

    }

}
