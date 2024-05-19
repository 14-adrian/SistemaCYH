
package Models;

import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.InputStream;

/**
 *
 * @author Leoni
 */
public class Users {
    
    public Users(){
        
    }
    
    public static void main(String[] args) {
        Map<String, String>  usuarios = misUsuarios();
        
        System.out.println(usuarios.get("root"));
        
        System.out.println("Diccionario completo:");
        for (Map.Entry<String, String> entry : usuarios.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
    
    public static Map<String, String> misUsuarios(){
         Map<String, String> us = new HashMap<>();
         
         try {
            // Cargar el archivo XML
            // Obtener el archivo XML desde el directorio de recursos
            InputStream inputStream = Users.class.getClassLoader().getResourceAsStream("UsersDesktop.xml");
            
            // Crear una fábrica de constructores de documentos
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Crear un constructor de documentos
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parsear el archivo XML
            Document doc = builder.parse(inputStream);

            // Obtener la lista de usuarios
            NodeList usuarioNodes = doc.getElementsByTagName("usuario");

            // Iterar sobre la lista de usuarios
            for (int i = 0; i < usuarioNodes.getLength(); i++) {
                Element usuarioElement = (Element) usuarioNodes.item(i);

                // Obtener el nombre de usuario y contraseña
                String nombre = usuarioElement.getElementsByTagName("nombre").item(0).getTextContent();
                String contrasena = usuarioElement.getElementsByTagName("contrasena").item(0).getTextContent();
                us.put(nombre, contrasena);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         
         
         return us;
    }
    
}
