package Forms;

import Forms.CustomPopUp.GlassPanePopup;
import Forms.CustomTables.ScrollBarCustomUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import Values.Colores;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author RAVEN
 */
public class CajaInfoPP extends javax.swing.JPanel {
    public String idUsuario = "0";
    private final Caja uss2;
    private final String estado;

    public CajaInfoPP(Caja uss, String _estado) {
        initComponents();
        setScroll();
        setOpaque(false);
        this.uss2 = uss;
        this.estado = _estado;
        txt.setBackground(new Color(0, 0, 0, 0));
        txt.setSelectionColor(new Color(48, 170, 63, 200));
        txt.setOpaque(false);
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
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
        okBtn1 = new Forms.CustomPopUp.OkBtn();
        btnSell = new Forms.CustomPopUp.OkBtn();
        btnDel1 = new Forms.CustomPopUp.OkBtn();
        scroll = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextPane();
        btnFinish = new Forms.CustomPopUp.OkBtn();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 25, 25, 25));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(80, 80, 80));
        jLabel1.setText("Informacion de la orden");

        okBtn1.setBackground(Colores.cbtnDel);
        okBtn1.setForeground(new java.awt.Color(255, 255, 255));
        okBtn1.setText("Preparacion");
        okBtn1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        okBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtn1ActionPerformed(evt);
            }
        });

        btnSell.setBackground(new java.awt.Color(0, 0, 102));
        btnSell.setForeground(new java.awt.Color(255, 255, 255));
        btnSell.setText("Cobrar");
        btnSell.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSellActionPerformed(evt);
            }
        });

        btnDel1.setBackground(new java.awt.Color(153, 0, 0));
        btnDel1.setForeground(new java.awt.Color(255, 255, 255));
        btnDel1.setText("Eliminar Orden");
        btnDel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnDel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDel1ActionPerformed(evt);
            }
        });

        txt.setEditable(false);
        txt.setBackground(new java.awt.Color(255, 255, 255));
        txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt.setForeground(new java.awt.Color(0, 0, 0));
        txt.setText("Nombre de usuario o contraseña incorrecto, vuelva a verificar los datos");
        scroll.setViewportView(txt);

        btnFinish.setBackground(new java.awt.Color(0, 204, 0));
        btnFinish.setForeground(new java.awt.Color(255, 255, 255));
        btnFinish.setText("Finalizado");
        btnFinish.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSell, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(okBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(302, Short.MAX_VALUE))
                    .addComponent(scroll)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void okBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtn1ActionPerformed
         uss2.cambiarEstado(idUsuario, "en preparacion");
         uss2.actualizar();
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_okBtn1ActionPerformed

    private void btnSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSellActionPerformed
         uss2.cambiarEstado(idUsuario, "entregado");
         uss2.actualizar();
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_btnSellActionPerformed

    private void btnDel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDel1ActionPerformed
        uss2.cambiarEstado(idUsuario, "fallido");
        uss2.actualizar();
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_btnDel1ActionPerformed

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed
        uss2.cambiarEstado(idUsuario, "finalizado");
        uss2.actualizar();
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_btnFinishActionPerformed

    public void eventOK(ActionListener event) {
        okBtn1.addActionListener(event);
    }
    public void setText(String tx){
        txt.setText(tx);
    }
    public void eventState(String _state){
        if(_state.equals("pendiente")){
            btnSell.setVisible(false);
            okBtn1.setVisible(true);
            btnFinish.setVisible(false);
        }
        if(_state.equals("en preparacion")){
            btnSell.setVisible(false);
            okBtn1.setVisible(false);
            btnFinish.setVisible(true);
        }
        if(_state.equals("finalizado")){
            okBtn1.setVisible(false);
            btnFinish.setVisible(false);
            btnSell.setVisible(true);
        }
        if(_state.equals("entregado")){
            btnFinish.setVisible(false);
            okBtn1.setVisible(false);
            btnSell.setVisible(false);
        }
        
    }
    private void setScroll(){
        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics grphcs) {
                super.paint(grphcs);
                grphcs.setColor(new Color(220, 220, 220));
                grphcs.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
                grphcs.dispose();
            }
        };
        scroll.setBorder(new LineBorder(new Color(220, 220, 220)));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.getVerticalScrollBar().setUI(new ScrollBarCustomUI());
        scroll.getHorizontalScrollBar().setUI(new ScrollBarCustomUI());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Forms.CustomPopUp.OkBtn btnDel1;
    private Forms.CustomPopUp.OkBtn btnFinish;
    private Forms.CustomPopUp.OkBtn btnSell;
    private javax.swing.JLabel jLabel1;
    private Forms.CustomPopUp.OkBtn okBtn1;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextPane txt;
    // End of variables declaration//GEN-END:variables
}
