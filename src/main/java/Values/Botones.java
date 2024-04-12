
package Values;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Botones {
    


    // Clase para definir un botón con bordes curvos
    public static class CurvedButton extends JButton {
        public CurvedButton(String text, Color c) {
            super(text);
            setContentAreaFilled(false); // Hace que el área de contenido no sea dibujada por el botón
            setFocusPainted(false); // Evita que se pinte un borde al recibir foco
            setBorder(new RoundBorder(20, 3, c)); // Puedes ajustar el radio, el grosor y el color aquí
            setOpaque(false); // Hace que el botón sea transparente
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (getModel().isPressed()) {
                g.setColor(Colores.cFondoMenu); // Cambia el color si el botón está presionado
            } else {
                g.setColor(getBackground());
            }
            g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Dibuja el fondo redondeado
            super.paintComponent(g);
        }
    }

    // Clase para definir un borde curvo con grosor y color
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
