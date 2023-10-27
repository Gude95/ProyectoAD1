package model;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
public class XML {
 public void exportarXML(File exportarXML, String nombre, String edad, String correo){
     try {
         // Crear el DOM
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder = factory.newDocumentBuilder();
         DOMImplementation implementation = builder.getDOMImplementation();
         Document doc = implementation.createDocument(null, "usuario", null);

         // Manipular el DOM
         Element root = doc.getDocumentElement();
         Element elemento1 = doc.createElement("nombre");
         root.appendChild(elemento1);
         elemento1.setTextContent(nombre);
         Element elemento2 = doc.createElement("edad");
         elemento2.setTextContent(edad);
         root.appendChild(elemento2);
         Element elemento3 = doc.createElement("email");
         elemento3.setTextContent(correo);
         root.appendChild(elemento3);

         // Exportar a un fichero XML
         File outputFile = exportarXML;
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
         DOMSource source = new DOMSource(doc);
         StreamResult result = new StreamResult(outputFile);
         transformer.transform(source, result);
     } catch (Exception e) {
         throw new RuntimeException(e);
     }
 }
}
