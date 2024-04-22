package Forms;

import Forms.CustomPopUp.GlassPanePopup;
import Forms.CustomTextFields.TextField;
import Models.ConexionDB;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import Values.Colores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RAVEN
 */
public class UsuariosAddPP extends javax.swing.JPanel {

    //----------------Global Variables
    private ConexionDB cn = new ConexionDB();
    private ResultSet rs;
    private final Usuarios uss2;

    //-----------------Custom Constructor
    private void initLabels(TextField txx) {
        txx.setBackground(new Color(0, 0, 0, 0));
        txx.setSelectionColor(new Color(48, 170, 63, 200));
        txx.setOpaque(false);
    }

    public UsuariosAddPP(Usuarios uss) {
        
        initComponents();
        this.uss2 = uss;
        setOpaque(false);

        initLabels(txtUser);
        initLabels(txtPass);
        initLabels(txtCargo);
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
        btnCancel = new Forms.CustomPopUp.OkBtn();
        txtUser = new Forms.CustomTextFields.TextField();
        txtPass = new Forms.CustomTextFields.TextField();
        txtCargo = new Forms.CustomTextFields.TextField();
        btnOk = new Forms.CustomPopUp.OkBtn();
        txtError = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 25, 25, 25));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(80, 80, 80));
        jLabel1.setText("Agregar Usuario");

        btnCancel.setBackground(Colores.cFondoMenu);
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancelar");
        btnCancel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtUser.setLabelText("Usuario");

        txtPass.setLabelText("Contraseña");

        txtCargo.setLabelText("Cargo");

        btnOk.setBackground(Colores.cbtnDel);
        btnOk.setForeground(new java.awt.Color(255, 255, 255));
        btnOk.setText("Aceptar");
        btnOk.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        txtError.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        txtError.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                            .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed

    }//GEN-LAST:event_cmdCancelActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
         GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        java.sql.Connection con2 = null;
        PreparedStatement pst = null;
        String username = txtUser.getText();
        String password = txtPass.getText();
        String cargo = txtCargo.getText();

        if (!username.isEmpty() && !password.isEmpty() && !cargo.isEmpty()) {
            con2 = cn.getConnection();
            try {
                pst = con2.prepareStatement("INSERT INTO users_table (`user_id`, user_name, user_password, user_role) " + "VALUES (NULL, ?, ?, ?)");
                pst.setString(1, username);
                pst.setString(2, password);
                pst.setString(3, cargo);
                pst.execute();
                uss2.actualizar();
                GlassPanePopup.closePopupLast();
            } catch (SQLException ex) {
                txtError.setText("Error al agregar el usuario!!");
            }
        } else {
            txtError.setText("Los campos estan vacios, por favor introduzca los datos correctamente!!");
        }

    }//GEN-LAST:event_btnOkActionPerformed

    public void eventOK(ActionListener event) {
        btnCancel.addActionListener(event);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Forms.CustomPopUp.OkBtn btnCancel;
    private Forms.CustomPopUp.OkBtn btnOk;
    private javax.swing.JLabel jLabel1;
    private Forms.CustomTextFields.TextField txtCargo;
    private javax.swing.JLabel txtError;
    private Forms.CustomTextFields.TextField txtPass;
    private Forms.CustomTextFields.TextField txtUser;
    // End of variables declaration//GEN-END:variables

}
