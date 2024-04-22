package Forms;

import Controllers.OrdersController;
import Forms.CustomPopUp.GlassPanePopup;
import Forms.CustomPopUp.OkBtn;
import Forms.CustomTables.TableCustom;
import Forms.CustomTables.UnderlinedHeaderRenderer;
import Models.Order;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import Values.Colores;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Leoni
 */
public class Caja extends javax.swing.JFrame {
    private OrdersController order = new OrdersController(this);
    private LoginPP diagError = new LoginPP();
    private String idUsuario = "0";
    private CajaInfoPP diagInfo = new CajaInfoPP(this, "activo");
    private DefaultTableModel model;

    public Caja() {
        initComponents();
        GlassPanePopup.install(this);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension size = getSize();
        bg.setSize(size.width, size.height);
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        tblInformes.getTableHeader().setDefaultRenderer(new UnderlinedHeaderRenderer());
        mostrarTabla();

        txtBuscar.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtBuscar.getText().equals("Buscar")) {
                    txtBuscar.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtBuscar.getText().isEmpty()) {
                    txtBuscar.setText("Buscar");
                }
            }
        });

        ImageIcon image = new ImageIcon("..\\AdministracionCyM\\src\\main\\java\\Media\\baseline_arrow_back_black_24dp.png");
        btnRegresar.setIcon((Icon) image);

    }
    
    public void mostrarTabla(){
        String[] columnNames = {"ID", "Fecha", "Camarero", "Cliente", "Estado", "Accion"};
        Object[][] data = order.orderList();

        model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int column) {
                return column == 5 ? OkBtn.class : Object.class;
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Deshabilitar la edición de todas las celdas
            }
        };

        tblInformes.setModel(model);

        

        

        tblInformes.getColumn("Accion").setCellRenderer(new ButtonRenderer());
        tblInformes.getColumn("Accion").setCellEditor(new ButtonEditor(new JTextField()));
    }
    
    public void vaciarTabla() {

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }
    
    public void actualizar() {
        vaciarTabla();
        mostrarTabla();
    }
    //-------------------------------------------------------------------------------------
    public void error(String msg){
        diagError.setText(msg);
         GlassPanePopup.showPopup(diagError);
    }
    public void cambiarEstado(String _id){
        order.setOrderState(_id);
    }

    class ButtonRenderer extends OkBtn implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(false);

        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            setBackground(Colores.cbtnDel); // Cambia el color del botón aquí
            setForeground(Color.WHITE); // Cambia el color del texto del botón aquí
            setFont(new Font("Segoe UI", 1, 14)); // Cambia el tipo de fuente del botón aquí
            setPreferredSize(new Dimension(60, 25)); // Cambia el tamaño del botón aquí
            setFocusPainted(false);
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {

        private OkBtn button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JTextField textField) {
            super(textField);
            button = new OkBtn();
            button.setOpaque(true);
            button.addActionListener(e -> fireEditingStopped());
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(Colores.cFondoMenu);
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(Colores.cbtnDel); // Cambia el color del botón aquí
            }
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // Cambia el tipo de fuente del botón aquí
            isPushed = true;
            return button;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        tableScrollButton1 = new Forms.CustomTables.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInformes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuarios");
        setLocation(new java.awt.Point(0, 0));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                bgresize(evt);
            }
        });

        txtBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBuscar.setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1288, 512));

        tblInformes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblInformes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "Camarero", "Cliente", "Estado", "Accion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInformes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInformesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInformes);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 1288, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Buscar");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresar)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bgresize(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_bgresize
        Dimension size = getSize();
        bg.setSize(size.width, size.height);
    }//GEN-LAST:event_bgresize

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        jPanel2.setBackground(Colores.cbtnDel);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        jPanel2.setBackground(Color.white);     // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseExited

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        Main mm = new Main();
        mm.setVisible(true);
        dispose();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void tblInformesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInformesMouseClicked
        int iRow = this.tblInformes.getSelectedRow();
        String usSrch = this.tblInformes.getValueAt(iRow, 0).toString();   
        diagInfo.setIdUsuario(usSrch);
        diagInfo.setText(order.getOrderDetails(usSrch));
         GlassPanePopup.showPopup(diagInfo);
    }//GEN-LAST:event_tblInformesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Caja().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private Forms.CustomTables.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tblInformes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
