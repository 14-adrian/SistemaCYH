package Forms;

import Values.BottomBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import Values.Colores;
import static Values.Imagenes.getScaledImage;
import Values.Ventanas;
import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Leoni
 */
public class Main extends javax.swing.JFrame {
    /**
     * Creates new form Login
     */
    public Main() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension size = getSize();
        bg.setSize(size.width, size.height);
        btnCaja.setBorder(Colores.borderxl);
        btnPedidos.setBorder(Colores.borderxl);

        ImageIcon logoIcon = new ImageIcon("..\\AdministracionCyM\\src\\main\\java\\Media\\LogoCyH_mini.png"); // Cambia la ruta por la ubicación de tu logo

        int width = 300; // Cambia el ancho deseado
        int height = 300; // Cambia el alto deseado

        Image scaledImg = getScaledImage(logoIcon.getImage(), width, height);

        // Crear un nuevo ImageIcon con la imagen escalada
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        // Crear una etiqueta para mostrar el logo
        JLabel logoLabel = new JLabel(scaledIcon);
        logoLabel.setBackground(Color.WHITE);
        pnlLogo.add(logoLabel, BorderLayout.CENTER);

        ImageIcon iconoH = new ImageIcon("..\\AdministracionCyM\\src\\main\\java\\Media\\baseline_home_white_24dp.png"); // Reemplaza la ruta con la ubicación de tu imagen

        lblHome.setIcon(iconoH);
        ImageIcon iconoU = new ImageIcon("..\\AdministracionCyM\\src\\main\\java\\Media\\baseline_person_white_24dp.png"); // Reemplaza la ruta con la ubicación de tu imagen

        lblUser.setIcon(iconoU);
        ImageIcon iconoI = new ImageIcon("..\\AdministracionCyM\\src\\main\\java\\Media\\baseline_table_view_white_24dp.png"); // Reemplaza la ruta con la ubicación de tu imagen

        lblTab.setIcon(iconoI);
        BottomBorder bottomBorder = new BottomBorder(Color.white, 1);
        // Establecer el borde personalizado en el panel
        btnInicio.setBorder(bottomBorder);
        btnUsuarios.setBorder(bottomBorder);
        btnInformes.setBorder(bottomBorder);

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
        plLogin = new javax.swing.JPanel();
        btnInicio = new javax.swing.JPanel();
        jLabelx3 = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        jLabelx7 = new javax.swing.JLabel();
        btnInformes = new javax.swing.JPanel();
        jLabelx4 = new javax.swing.JLabel();
        lblTab = new javax.swing.JLabel();
        pnlLogo = new javax.swing.JPanel();
        btnCaja = new javax.swing.JPanel();
        jLabelx5 = new javax.swing.JLabel();
        btnPedidos = new javax.swing.JPanel();
        jLabelx6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                bgresize(evt);
            }
        });

        plLogin.setBackground(Colores.cFondoMenu);
        plLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        plLogin.setName(""); // NOI18N

        btnInicio.setBackground(Colores.cFondoMenu);
        btnInicio.setForeground(new java.awt.Color(0, 0, 0));
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInicioMouseExited(evt);
            }
        });

        jLabelx3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelx3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabelx3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelx3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelx3.setText("INICIO");
        jLabelx3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout btnInicioLayout = new javax.swing.GroupLayout(btnInicio);
        btnInicio.setLayout(btnInicioLayout);
        btnInicioLayout.setHorizontalGroup(
            btnInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnInicioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHome, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelx3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        btnInicioLayout.setVerticalGroup(
            btnInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelx3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnUsuarios.setBackground(Colores.cFondoMenu);
        btnUsuarios.setForeground(new java.awt.Color(0, 0, 0));
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseExited(evt);
            }
        });

        jLabelx7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelx7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabelx7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelx7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelx7.setText("USUARIOS");
        jLabelx7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout btnUsuariosLayout = new javax.swing.GroupLayout(btnUsuarios);
        btnUsuarios.setLayout(btnUsuariosLayout);
        btnUsuariosLayout.setHorizontalGroup(
            btnUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelx7, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnUsuariosLayout.setVerticalGroup(
            btnUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelx7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnInformes.setBackground(Colores.cFondoMenu);
        btnInformes.setForeground(new java.awt.Color(0, 0, 0));
        btnInformes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInformes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInformesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInformesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInformesMouseExited(evt);
            }
        });

        jLabelx4.setBackground(java.awt.Color.darkGray);
        jLabelx4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabelx4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelx4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelx4.setText("INFORMES");
        jLabelx4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout btnInformesLayout = new javax.swing.GroupLayout(btnInformes);
        btnInformes.setLayout(btnInformesLayout);
        btnInformesLayout.setHorizontalGroup(
            btnInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnInformesLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(lblTab, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelx4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnInformesLayout.setVerticalGroup(
            btnInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnInformesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelx4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlLogo.setBackground(Colores.cFondoMenu);
        pnlLogo.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout plLoginLayout = new javax.swing.GroupLayout(plLogin);
        plLogin.setLayout(plLoginLayout);
        plLoginLayout.setHorizontalGroup(
            plLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(plLoginLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(plLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnInformes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        plLoginLayout.setVerticalGroup(
            plLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plLoginLayout.createSequentialGroup()
                .addComponent(pnlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInformes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnInicio.getAccessibleContext().setAccessibleName("");
        btnInicio.getAccessibleContext().setAccessibleDescription("");

        btnCaja.setBackground(Colores.cbtnMActions);
        btnCaja.setBorder(Colores.borderxl);
        btnCaja.setForeground(new java.awt.Color(0, 0, 0));
        btnCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCaja.setMaximumSize(new java.awt.Dimension(300, 300));
        btnCaja.setPreferredSize(new java.awt.Dimension(400, 300));
        btnCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCajaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCajaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCajaMouseExited(evt);
            }
        });

        jLabelx5.setBackground(java.awt.Color.darkGray);
        jLabelx5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 48)); // NOI18N
        jLabelx5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelx5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelx5.setText("CAJA");
        jLabelx5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout btnCajaLayout = new javax.swing.GroupLayout(btnCaja);
        btnCaja.setLayout(btnCajaLayout);
        btnCajaLayout.setHorizontalGroup(
            btnCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelx5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
        );
        btnCajaLayout.setVerticalGroup(
            btnCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCajaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelx5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnPedidos.setBackground(Colores.cbtnMActions);
        btnPedidos.setForeground(new java.awt.Color(0, 0, 0));
        btnPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPedidos.setMaximumSize(new java.awt.Dimension(300, 300));
        btnPedidos.setPreferredSize(new java.awt.Dimension(400, 300));
        btnPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPedidosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPedidosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPedidosMouseExited(evt);
            }
        });

        jLabelx6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelx6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 48)); // NOI18N
        jLabelx6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelx6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelx6.setText("PEDIDOS");
        jLabelx6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout btnPedidosLayout = new javax.swing.GroupLayout(btnPedidos);
        btnPedidos.setLayout(btnPedidosLayout);
        btnPedidosLayout.setHorizontalGroup(
            btnPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelx6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
        );
        btnPedidosLayout.setVerticalGroup(
            btnPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelx6, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(plLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnCaja, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addGap(55, 55, 55)
                .addComponent(btnPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(264, Short.MAX_VALUE))
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

    private void btnInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseClicked


    }//GEN-LAST:event_btnInicioMouseClicked

    //------------------Botones----------------------------------

    private void btnInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseEntered
        btnInicio.setBackground(Colores.cbtnMEnt);
    }//GEN-LAST:event_btnInicioMouseEntered

    private void btnInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseExited

        btnInicio.setBackground(Colores.cFondoMenu);
    }//GEN-LAST:event_btnInicioMouseExited

    private void btnUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseClicked
        Usuarios nU = new Usuarios();
        nU.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnUsuariosMouseClicked

    private void btnUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseEntered
        btnUsuarios.setBackground(Colores.cbtnMEnt);
    }//GEN-LAST:event_btnUsuariosMouseEntered

    private void btnUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseExited
        btnUsuarios.setBackground(Colores.cFondoMenu);
    }//GEN-LAST:event_btnUsuariosMouseExited

    private void btnInformesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInformesMouseClicked
        Informes nU = new Informes();
        nU.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnInformesMouseClicked

    private void btnInformesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInformesMouseEntered
        btnInformes.setBackground(Colores.cbtnMEnt);
    }//GEN-LAST:event_btnInformesMouseEntered

    private void btnInformesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInformesMouseExited
        btnInformes.setBackground(Colores.cFondoMenu);
    }//GEN-LAST:event_btnInformesMouseExited

    private void btnCajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCajaMouseClicked
        Caja cc = new Caja();
        cc.setVisible(true);
        dispose();

    }//GEN-LAST:event_btnCajaMouseClicked

    private void btnCajaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCajaMouseEntered
        btnCaja.setBackground(Colores.cbtnMEnt);
    }//GEN-LAST:event_btnCajaMouseEntered

    private void btnCajaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCajaMouseExited
        btnCaja.setBackground(Colores.cbtnMActions);
    }//GEN-LAST:event_btnCajaMouseExited

    private void btnPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPedidosMouseClicked
        if(Ventanas.getCant() == 0){
            Pedidos pp = new Pedidos();
            pp.setVisible(true);
            Ventanas.setCant(1);
        }
        
    }//GEN-LAST:event_btnPedidosMouseClicked

    private void btnPedidosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPedidosMouseEntered
        btnPedidos.setBackground(Colores.cbtnMEnt);
    }//GEN-LAST:event_btnPedidosMouseEntered

    private void btnPedidosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPedidosMouseExited
        btnPedidos.setBackground(Colores.cbtnMActions);
    }//GEN-LAST:event_btnPedidosMouseExited

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Main().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel btnCaja;
    private javax.swing.JPanel btnInformes;
    private javax.swing.JPanel btnInicio;
    private javax.swing.JPanel btnPedidos;
    private javax.swing.JPanel btnUsuarios;
    private javax.swing.JLabel jLabelx3;
    private javax.swing.JLabel jLabelx4;
    private javax.swing.JLabel jLabelx5;
    private javax.swing.JLabel jLabelx6;
    private javax.swing.JLabel jLabelx7;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblTab;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel plLogin;
    private javax.swing.JPanel pnlLogo;
    // End of variables declaration//GEN-END:variables
}
