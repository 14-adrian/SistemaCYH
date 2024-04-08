
package Values;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;

/**
 *
 * @author Leoni
 */
public class Botones {
    public Botones(){
        
    }
    
    public  static JLabel ButtonText(String text){
        JLabel label = new JLabel(text);
        return label;
    }
    
    public static  GridBagConstraints FillContent(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0; // Permitir que el componente se expanda horizontalmente
        gbc.weighty = 1.0; // Permitir que el componente se expanda verticalmente
        gbc.fill = GridBagConstraints.BOTH;
        return gbc;
    }
    
}
