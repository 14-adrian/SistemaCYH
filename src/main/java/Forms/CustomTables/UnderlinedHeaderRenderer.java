
package Forms.CustomTables;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Leoni
 */
public class UnderlinedHeaderRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            label.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK)); // Underline border
            label.setHorizontalAlignment(SwingConstants.LEFT); // Center align text
            label.setFont(label.getFont().deriveFont(Font.BOLD)); // Bold font
            label.setBackground(Color.WHITE); // Set background color to white
            label.setOpaque(true); // Ensure background
            return label;
        }
    }
