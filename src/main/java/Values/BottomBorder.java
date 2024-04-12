
package Values;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;

public class BottomBorder extends AbstractBorder {
    private Color color;
    private int thickness;

    public BottomBorder(Color color, int thickness) {
        this.color = color;
        this.thickness = thickness;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(color);
        g2d.fillRect(x, y + height - thickness, width, thickness);
        g2d.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, thickness, 0);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = 0;
        insets.top = 0;
        insets.right = 0;
        insets.bottom = thickness;
        return insets;
    }
}

