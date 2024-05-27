package Forms;

import Models.DBController;
import Forms.CustomPopUp.GlassPanePopup;
import Forms.CustomTextFields.PasswordField;
import Forms.CustomTextFields.TextField;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import Values.Colores;
import java.util.List;

/**
 *
 * @author RAVEN
 */
public class ConfigDBPP extends javax.swing.JPanel {

    //----------------Global Variables
    private final MainAdmin mad;
    private DBController dbXml = new DBController();

    //-----------------Custom Constructor
    private void initLabels(TextField txx) {
        txx.setBackground(new Color(0, 0, 0, 0));
        txx.setSelectionColor(new Color(48, 170, 63, 200));
        txx.setOpaque(false);
    }
    
    private void initPassLabels(PasswordField txx){
        txx.setBackground(new Color(0, 0, 0, 0));
        txx.setSelectionColor(new Color(48, 170, 63, 200));
        txx.setOpaque(false);
    }
    
    public void readingConfig(){
        String filePath = "DBConfig.xml";
        List<String> configData = dbXml.readConfig(filePath);
        
        System.out.println("Host: " + configData.get(0));
        System.out.println("DB: " + configData.get(1));
        System.out.println("User: " + configData.get(2));
        System.out.println("Password: " + configData.get(3));
        
        txtHost.setText(configData.get(0));
        txtDB.setText(configData.get(1));
        txtUser.setText(configData.get(2));
        txtPass.setText(configData.get(3));
    }

    public ConfigDBPP(MainAdmin _mad) {
        
        initComponents();
        this.mad = _mad;
        setOpaque(false);

        initLabels(txtHost);
        initLabels(txtDB);
        initLabels(txtUser);
        initPassLabels(txtPass);
        readingConfig();
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
        txtHost = new Forms.CustomTextFields.TextField();
        txtDB = new Forms.CustomTextFields.TextField();
        txtUser = new Forms.CustomTextFields.TextField();
        btnOk = new Forms.CustomPopUp.OkBtn();
        txtError = new javax.swing.JLabel();
        txtPass = new Forms.CustomTextFields.PasswordField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 25, 25, 25));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(80, 80, 80));
        jLabel1.setText("Configuracion");

        btnCancel.setBackground(Colores.cFondoMenu);
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancelar");
        btnCancel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtHost.setLabelText("Dominio");

        txtDB.setLabelText("Base de Datos");

        txtUser.setLabelText("Usuario");

        btnOk.setBackground(Colores.cbtnDel);
        btnOk.setForeground(new java.awt.Color(255, 255, 255));
        btnOk.setText("Guardar Cambios");
        btnOk.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        txtError.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        txtError.setForeground(new java.awt.Color(255, 51, 51));

        txtPass.setText("passwordField1");
        txtPass.setLabelText("Contraseña");
        txtPass.setShowAndHide(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(txtHost, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                            .addComponent(txtDB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(3, 3, 3))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
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
        String urlString = "DBConfig.xml"; // Reemplaza con la URL de tu archivo XML
        String newHost = txtHost.getText();
        String newDB = txtDB.getText();
        String newUser = txtUser.getText();
        String newPassword = txtPass.getText();

        DBController.editarArchivoXML(urlString, newHost, newDB, newUser, newPassword);
        
        GlassPanePopup.closePopupLast();
       
        
        mad.reiniciarAplicacion();
    }//GEN-LAST:event_btnOkActionPerformed

    public void eventOK(ActionListener event) {
        btnCancel.addActionListener(event);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Forms.CustomPopUp.OkBtn btnCancel;
    private Forms.CustomPopUp.OkBtn btnOk;
    private javax.swing.JLabel jLabel1;
    private Forms.CustomTextFields.TextField txtDB;
    private javax.swing.JLabel txtError;
    private Forms.CustomTextFields.TextField txtHost;
    private Forms.CustomTextFields.PasswordField txtPass;
    private Forms.CustomTextFields.TextField txtUser;
    // End of variables declaration//GEN-END:variables

}
