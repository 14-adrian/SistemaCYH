package Forms;

import Controllers.OrdersController;
import Controllers.ReportsController;
import Forms.CustomPopUp.GlassPanePopup;
import Forms.CustomPopUp.OkBtn;
import Forms.CustomTables.TableCustom;
import Forms.CustomTables.UnderlinedHeaderRenderer;
import Values.Botones;
import Values.BottomBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import Values.Colores;
import static Values.Imagenes.getScaledImage;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Leoni
 */
public class Informes extends javax.swing.JFrame {

    private LoginPP diagError = new LoginPP();
    private InformesInfoPP diagInfo = new InformesInfoPP(this, "activo");
    private InformesGenerarInformePP diagGen = new InformesGenerarInformePP(this);
    private DefaultTableModel model;
    private OrdersController order = new OrdersController(this);
    private ReportsController report = new ReportsController(this);
    private boolean search;

    /**
     * Creates new form Login
     */
    public Informes() {
        initComponents();
        GlassPanePopup.install(this);
        search = true;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension size = getSize();
        bg.setSize(size.width, size.height);

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/Media/LogoCyH_mini.png")); // Cambia la ruta por la ubicación de tu logo

        int width = 300; // Cambia el ancho deseado
        int height = 300; // Cambia el alto deseado

        Image scaledImg = getScaledImage(logoIcon.getImage(), width, height);

        // Crear un nuevo ImageIcon con la imagen escalada
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        // Crear una etiqueta para mostrar el logo
        JLabel logoLabel = new JLabel(scaledIcon);
        logoLabel.setBackground(Color.WHITE);
        pnlLogo.add(logoLabel, BorderLayout.CENTER);

        ImageIcon iconoH = new ImageIcon(getClass().getResource("/Media/baseline_home_white_24dp.png")); // Reemplaza la ruta con la ubicación de tu imagen

        lblHome.setIcon(iconoH);
        ImageIcon iconoU = new ImageIcon(getClass().getResource("/Media/baseline_person_white_24dp.png")); // Reemplaza la ruta con la ubicación de tu imagen

        lblUser.setIcon(iconoU);
        ImageIcon iconoI = new ImageIcon(getClass().getResource("/Media/baseline_table_view_white_24dp.png")); // Reemplaza la ruta con la ubicación de tu imagen

        lblTab.setIcon(iconoI);
        BottomBorder bottomBorder = new BottomBorder(Color.white, 1);
        // Establecer el borde personalizado en el panel
        btnInicio.setBorder(bottomBorder);
        btnUsuarios.setBorder(bottomBorder);
        btnInformes.setBorder(bottomBorder);

        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        tblInformes.getTableHeader().setDefaultRenderer(new UnderlinedHeaderRenderer());
        //String cam = txtSrch.getText().toUpperCase();
        mostrarTabla("");


    }

    public void mostrarTabla(String _cam) {
        String[] columnNames = {"ID", "Fecha", "Camarero", "Cliente", "Estado", "Accion"};
        Object[][] data = report.orderList(_cam);

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

        tblInformes.getColumn("Accion").setCellRenderer(new Informes.ButtonRenderer());
        tblInformes.getColumn("Accion").setCellEditor(new Informes.ButtonEditor(new JTextField()));
    }

    public void vaciarTabla() {

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    public void actualizar() {
        vaciarTabla();
        mostrarTabla("");
    }

    public void error(String msg) {
        diagError.setText(msg);
        GlassPanePopup.showPopup(diagError);
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
        jPanel1 = new javax.swing.JPanel();
        tableScrollButton1 = new Forms.CustomTables.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInformes = new javax.swing.JTable();
        txtSrch = new Forms.CustomTextFields.TextField();
        jLabel1 = new javax.swing.JLabel();
        btnGen = new Forms.CustomPopUp.OkBtn();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuarios");
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
                .addComponent(jLabelx3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
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
                .addContainerGap()
                .addComponent(lblTab, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
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
                    .addComponent(btnInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, Short.MAX_VALUE))
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
                .addContainerGap(513, Short.MAX_VALUE))
        );

        btnInicio.getAccessibleContext().setAccessibleName("");
        btnInicio.getAccessibleContext().setAccessibleDescription("");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblInformes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblInformes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Accion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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
        if (tblInformes.getColumnModel().getColumnCount() > 0) {
            tblInformes.getColumnModel().getColumn(0).setPreferredWidth(600);
        }

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txtSrch.setLabelText("Buscar Camarero");
        txtSrch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSrchKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("FECHA:---------");

        btnGen.setBackground(Colores.cbtnDel);
        btnGen.setForeground(new java.awt.Color(255, 255, 255));
        btnGen.setText("GENERAR INFORME");
        btnGen.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(plLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(txtSrch, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGen, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSrch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addComponent(btnGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        Main nU = new Main();
        nU.setVisible(true);
        dispose();

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

    private void tblInformesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInformesMouseClicked
        int iRow = this.tblInformes.getSelectedRow();
        String usSrch = this.tblInformes.getValueAt(iRow, 0).toString();
        String usStat = this.tblInformes.getValueAt(iRow, 4).toString();
        diagInfo.setIdUsuario(usSrch);
        diagInfo.setText(order.getOrderDetails(usSrch));
        GlassPanePopup.showPopup(diagInfo);
    }//GEN-LAST:event_tblInformesMouseClicked

    private void txtSrchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSrchKeyReleased
         if (search) {
            String cam = txtSrch.getText().toUpperCase();
            vaciarTabla();
            mostrarTabla(cam);
        }
    }//GEN-LAST:event_txtSrchKeyReleased

    private void btnGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenActionPerformed
       
        diagInfo.setText(report.getDailyDetails());
        GlassPanePopup.showPopup(diagInfo);
    }//GEN-LAST:event_btnGenActionPerformed

    

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
            java.util.logging.Logger.getLogger(Informes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informes().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private Forms.CustomPopUp.OkBtn btnGen;
    private javax.swing.JPanel btnInformes;
    private javax.swing.JPanel btnInicio;
    private javax.swing.JPanel btnUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelx3;
    private javax.swing.JLabel jLabelx4;
    private javax.swing.JLabel jLabelx7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblTab;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel plLogin;
    private javax.swing.JPanel pnlLogo;
    private Forms.CustomTables.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tblInformes;
    private Forms.CustomTextFields.TextField txtSrch;
    // End of variables declaration//GEN-END:variables
}
