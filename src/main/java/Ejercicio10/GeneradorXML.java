/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio10;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Guille
 */
public class GeneradorXML {
        
    public static void main(String[] args) throws ParserConfigurationException {
        
        try {
            
            //A crear el árbol
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            //Elemento raíz
            Element nodoRaiz = document.createElement("instituto");
            document.appendChild(nodoRaiz); //Lo añado

            //Creo el elemento hijo
            Element nodoModulo = document.createElement("modulo");
            
            //Añado el atributo código = "DAM"
            nodoModulo.setAttribute("codigo", "DAM");
            
            //Añado "Acceso a Datos"
            nodoModulo.appendChild(document.createTextNode("Acceso a Datos"));

            //Colgamos <modulo> dentro de <instituto>
            nodoRaiz.appendChild(nodoModulo);


            //El transformador pasará a texto lo que hay en memoria
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            //Así queda identado y con saltos de línea.
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            

            //Este el origen del documento en memoria
            DOMSource source = new DOMSource(document);
            
            //Destino (instituto.xml)
            StreamResult result = new StreamResult(new File("instituto.xml"));

            //Hago la transformación y lo gurado
            transformer.transform(source, result);

            System.out.println("instituto.xml generado");

        } catch (ParserConfigurationException e) {
            System.err.println("Error del parser: " + e.getMessage());
        } catch (TransformerException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}
