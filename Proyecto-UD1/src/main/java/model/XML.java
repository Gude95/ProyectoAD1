package model;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XML {
    public void exportarXML(File exportarXML, String nombre, String edad, String correo) {
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
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(outputFile);
            transformer.transform(source, result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void exportarXMLAdmin(File exportarXML, Users users) {
        try {
            // Crear el DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document doc = implementation.createDocument(null, "usuarios", null);

            for (User user : users.getUsers().values()) {

                // Manipular el DOM
                Element root = doc.getDocumentElement();
                Element element = doc.createElement("usuario");
                root.appendChild(element);
                Element elemento1 = doc.createElement("nombre");
                element.appendChild(elemento1);
                elemento1.setTextContent(user.getName());
                Element elemento2 = doc.createElement("edad");
                elemento2.setTextContent(String.valueOf(user.getAge()));
                element.appendChild(elemento2);
                Element elemento3 = doc.createElement("email");
                elemento3.setTextContent(user.getEmail());
                element.appendChild(elemento3);

                // Exportar a un fichero XML
                File outputFile = exportarXML;
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(outputFile);
                transformer.transform(source, result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}