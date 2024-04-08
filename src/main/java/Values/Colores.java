
package Values;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author Leoni
 */
public class Colores {
    public Colores(){
        
    }
    
    public static Color cFondoMenu = getColor(20, 20, 20);
    public static Color cbtnMEnt = getColor(20, 20, 20);
    public static Color cbtnMEx = getColor(20, 20, 20);
    
    public static Color cbtnFEnt = getColor(20, 20, 20);
    public static Color cbtnFEx = getColor(20, 20, 20);
    
    public static Color cForeSel = getColor(255, 255, 255);
    public static Color cForeGen = getColor(20, 20, 20);
    
    
    
    public static Border borderxl = BorderFactory.createLineBorder(Color.gray, 3);
     public static Color getColor(int r, int g, int b){
         float[] hsb = new float[3];
         Color c;
        
         Color.RGBtoHSB(r, g, b, hsb);
         c = Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
         return c;
     }
     
     public static class RoundBorder implements Border {
        private int radius;
        private int thickness;
        private Color color;

        public RoundBorder(int radius, int thickness, Color color) {
            this.radius = radius;
            this.thickness = thickness;
            this.color = color;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + this.thickness, this.radius + this.thickness, this.radius + this.thickness, this.radius + this.thickness);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setStroke(new BasicStroke(this.thickness));
            g2d.setColor(this.color);

            g2d.drawRoundRect(x + this.thickness / 2, y + this.thickness / 2, width - this.thickness, height - this.thickness, this.radius, this.radius);
            g2d.dispose();
        }
    
    }
}
