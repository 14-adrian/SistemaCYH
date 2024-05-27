
package Models;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author Leoni
 */
public class DBController {
    
    public DBController(){
        
    }
    
    //---------------------------Metodo para editar el XML-------------------------------------
    
    public static void editarArchivoXML(String nombreArchivo, String host, String db, String usuario, String contraseña) {
        try {
            // Obtener la ruta del archivo XML desde los recursos de Maven
            ClassLoader classLoader = DBController.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(nombreArchivo);

            // Crear un DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parsear el archivo XML existente
            Document doc = dBuilder.parse(inputStream);

            // Obtener la raíz del documento
            Element root = doc.getDocumentElement();

            // Obtener los nodos con los nombres de los campos y actualizar sus valores
            actualizarValorCampo(doc, root, "host", host);
            actualizarValorCampo(doc, root, "DB", db);
            actualizarValorCampo(doc, root, "user", usuario);
            actualizarValorCampo(doc, root, "password", contraseña);

            // Escribir los cambios al archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            // Escribir el resultado a un archivo temporal
            //OutputStream outputStream = new FileOutputStream("temp.xml");
            //StreamResult result = new StreamResult(outputStream);
           // transformer.transform(source, result);
            
                // Reemplazar el archivo original con el archivo temporal
                // Aquí podrías moverlo a la ruta deseada si fuera necesario

           // Escribir los cambios a un nuevo archivo XML
           
            // Construir la ruta del nuevo archivo XML
            String nuevoNombreArchivo = "src/main/java/Models/DBConfig.xml";

            // Escribir los cambios a un nuevo archivo XML
            OutputStream outputStream = new FileOutputStream(nuevoNombreArchivo);
            guardarComoXML(doc, outputStream);

        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }
    
    private static void guardarComoXML(Document doc, OutputStream outputStream) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(outputStream);
        transformer.transform(source, result);
    }
    
    private static void actualizarValorCampo(Document doc, Element root, String tagName, String newValue) {
        NodeList nodeList = root.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            nodeList.item(0).setTextContent(newValue);
        } else {
            // Si el elemento no existe, se puede crear y agregar al documento
            Element nuevoElemento = doc.createElement(tagName);
            nuevoElemento.appendChild(doc.createTextNode(newValue));
            root.appendChild(nuevoElemento);
        }
    }
    
    
    //-----------------Metodo para leer los XML---------------------
    
    public List<String> readConfig(String filePath) {
        List<String> configData = new ArrayList<>();
        try {
            // Cargar el archivo XML
            InputStream inputStream = DBController.class.getClassLoader().getResourceAsStream(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parsear el archivo XML
            Document doc = builder.parse(inputStream);
            doc.getDocumentElement().normalize();

            // Obtener los valores de los elementos
            configData.add(getElementValue(doc, "host"));
            configData.add(getElementValue(doc, "DB"));
            configData.add(getElementValue(doc, "user"));
            configData.add(getElementValue(doc, "password"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return configData;
    }
    
    private static String getElementValue(Document doc, String tagName) {
        NodeList nodeList = doc.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return null;
    }
    
    
}
