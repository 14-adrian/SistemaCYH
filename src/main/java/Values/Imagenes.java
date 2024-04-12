
package Values;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author Leoni
 */
public class Imagenes {
    public Imagenes(){
        
    }
    public static Image getScaledImage(Image srcImg, int width, int height){
        // Crear un objeto BufferedImage para realizar el escalado
        BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        
        // Obtener el objeto Graphics2D de la imagen
        Graphics2D g2 = resizedImg.createGraphics();
        
        // Configurar los RenderingHints para un mejor escalado
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Dibujar la imagen escalada
        g2.drawImage(srcImg, 0, 0, width, height, null);
        g2.dispose(); // Liberar recursos del Graphics2D
        
        // Devolver la imagen escalada
        return resizedImg;
    }
}