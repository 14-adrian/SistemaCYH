package Forms;

import Forms.CustomPopUp.GlassPanePopup;
import Models.ConexionDB;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import Values.Colores;
import java.sql.PreparedStatement;

/**
 *
 * @author RAVEN
 */
public class UsuariosDelPP extends javax.swing.JPanel {

    public int idUsuario = 0;
    private ConexionDB cn = new ConexionDB();
    private final Usuarios uss2;

    public UsuariosDelPP(Usuarios uss) {
        initComponents();
        setOpaque(false);
        txt.setBackground(new Color(0, 0, 0, 0));
        txt.setSelectionColor(new Color(48, 170, 63, 200));
        txt.setOpaque(false);
        this.uss2 = uss;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        g2.dispose();
        super.paintComponent(grphcs);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt = new javax.swing.JTextPane();
        okBtn1 = new Forms.CustomPopUp.OkBtn();
        btnDel = new Forms.CustomPopUp.OkBtn();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 25, 25, 25));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(80, 80, 80));
        jLabel1.setText("Advertencia");

        txt.setEditable(false);
        txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt.setForeground(new java.awt.Color(133, 133, 133));
        txt.setText("Realmente desea eliminar el usuario?");

        okBtn1.setBackground(Colores.cbtnDel);
        okBtn1.setForeground(new java.awt.Color(255, 255, 255));
        okBtn1.setText("Cancelar");
        okBtn1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        okBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtn1ActionPerformed(evt);
            }
        });

        btnDel.setBackground(new java.awt.Color(153, 0, 0));
        btnDel.setForeground(new java.awt.Color(255, 255, 255));
        btnDel.setText("Eliminar");
        btnDel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 472, Short.MAX_VALUE))
                    .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(okBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed

    }//GEN-LAST:event_cmdCancelActionPerformed

    private void okBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtn1ActionPerformed
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_okBtn1ActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        java.sql.Connection con2 = null;
        PreparedStatement pst = null;

        try {

            con2 = cn.getConnection();
            pst = con2.prepareStatement("DELETE FROM users_table WHERE `users_table`.`user_id` = " + Integer.toString(idUsuario) + "");
            pst.execute();
            uss2.actualizar();
            GlassPanePopup.closePopupLast();

        } catch (Exception e) {
            System.out.print("Ocurrio un error maje");
            GlassPanePopup.closePopupLast();
        }
    }//GEN-LAST:event_btnDelActionPerformed

    public void eventOK(ActionListener event) {
        okBtn1.addActionListener(event);
    }

    public void setText(String tx) {
        txt.setText(tx);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Forms.CustomPopUp.OkBtn btnDel;
    private javax.swing.JLabel jLabel1;
    private Forms.CustomPopUp.OkBtn okBtn1;
    private javax.swing.JTextPane txt;
    // End of variables declaration//GEN-END:variables
}
