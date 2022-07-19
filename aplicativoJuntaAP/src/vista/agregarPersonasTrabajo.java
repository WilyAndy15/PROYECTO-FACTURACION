package vista;

import aplicativojuntaap.metodos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.convocatoriaTrabajos;
import logica.manejador;
import static vista.registrarAsistenciasReuniones.isNumeric;

public class agregarPersonasTrabajo extends javax.swing.JDialog {

    public metodos metodos = new metodos();

    public agregarPersonasTrabajo(java.awt.Frame parent, boolean modal) {

        super(parent, modal);
        initComponents();
        this.setResizable(false);
        setTitle("Agregar Personas");
        setLocationRelativeTo(null);
        llenarCombo();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        buttonGroup_asistencias = new javax.swing.ButtonGroup();
        jLabel_titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_trabajos = new javax.swing.JComboBox<String>();
        jLabel_reunion = new javax.swing.JLabel();
        jTextField_nombreTrabajo = new javax.swing.JTextField();
        jLabel_reunion2 = new javax.swing.JLabel();
        jTextField_descripcionTrabajo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel_nombreReunion1 = new javax.swing.JLabel();
        jTextField_codigoUsuario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton_buscarUsuario = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel_fechaReunion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_usuarios = new javax.swing.JTable();
        jLabel_nombreReunion = new javax.swing.JLabel();
        jButton_agregarUsuario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(860, 500));
        setMinimumSize(new java.awt.Dimension(860, 500));
        setPreferredSize(new java.awt.Dimension(867, 582));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(28, 108, 171));
        jLabel_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_titulo.setText("Registrar Personas al Trabajo");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 830, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Seleccione un trabajo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jComboBox_trabajos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox_trabajos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_trabajosItemStateChanged(evt);
            }
        });
        jComboBox_trabajos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_trabajosActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_trabajos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 590, -1));

        jLabel_reunion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_reunion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_reunion.setText("Nombre del Trabajo");
        getContentPane().add(jLabel_reunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 169, 30));

        jTextField_nombreTrabajo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_nombreTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombreTrabajoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_nombreTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 590, -1));

        jLabel_reunion2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_reunion2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_reunion2.setText("Descripción Trabajo");
        getContentPane().add(jLabel_reunion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 30));

        jTextField_descripcionTrabajo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_descripcionTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_descripcionTrabajoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_descripcionTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 590, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 830, 20));

        jLabel_nombreReunion1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_nombreReunion1.setText("Ingrese el código del usuario a buscar");
        getContentPane().add(jLabel_nombreReunion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 30));

        jTextField_codigoUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_codigoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_codigoUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_codigoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 660, 40));

        jButton1.setBackground(new java.awt.Color(203, 23, 12));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 470, 130, 40));

        jButton_buscarUsuario.setBackground(new java.awt.Color(30, 139, 204));
        jButton_buscarUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_buscarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jButton_buscarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loupe.png"))); // NOI18N
        jButton_buscarUsuario.setText("Buscar");
        jButton_buscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_buscarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 240, 120, 39));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 830, 10));

        jLabel_fechaReunion.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jLabel_fechaReunion.setForeground(new java.awt.Color(28, 108, 171));
        jLabel_fechaReunion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_fechaReunion.setText("Socios");
        getContentPane().add(jLabel_fechaReunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 800, -1));

        jTable_usuarios.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombres", "Apellidos"
            }
        ));
        jScrollPane1.setViewportView(jTable_usuarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 798, 120));

        jLabel_nombreReunion.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel_nombreReunion.setText("Seleccione el usuario que desea*.");
        getContentPane().add(jLabel_nombreReunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 260, 43));

        jButton_agregarUsuario.setBackground(new java.awt.Color(0, 97, 155));
        jButton_agregarUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_agregarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jButton_agregarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add (1).png"))); // NOI18N
        jButton_agregarUsuario.setText("Agregar");
        jButton_agregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_agregarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_agregarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 124, 39));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 830, 460));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/texturas-pared-gris-fondo_74190-4389 (1).jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_trabajosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_trabajosActionPerformed
    }//GEN-LAST:event_jComboBox_trabajosActionPerformed

    private void jComboBox_trabajosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_trabajosItemStateChanged
        try {
            obtenerInformacion();
//            obtenerRegistrosNombres();
        } catch (SQLException ex) {
            Logger.getLogger(verReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox_trabajosItemStateChanged

    private void jButton_agregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_agregarUsuarioActionPerformed
        DefaultTableModel tm = (DefaultTableModel) jTable_usuarios.getModel();
        int fila = jTable_usuarios.getSelectedRow();
        String fecha = (String) jComboBox_trabajos.getSelectedItem();
        manejador mn = new manejador();
        String nombres;
        int id = 0;
        if (fila >= 0) {
            nombres = String.valueOf(tm.getValueAt(jTable_usuarios.getSelectedRow(), 0));

            try {
                id = Integer.parseInt(metodos.obtenerID(nombres));
            } catch (SQLException ex) {
                Logger.getLogger(registrarAsistenciasReuniones.class.getName()).log(Level.SEVERE, null, ex);
            }
            convocatoriaTrabajos ct = mn.crearConvocatoriaTrabajos(fecha, id, 0);
            try {
                metodos.crearUsuarioConTrabajo(ct);
                jTextField_codigoUsuario.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(agregarPersonasTrabajo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton_agregarUsuarioActionPerformed

    private void jTextField_codigoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_codigoUsuarioActionPerformed
        if (jTextField_codigoUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe llenar el campo a buscar");
        } else {
            obtenerUsuario();
        }
    }//GEN-LAST:event_jTextField_codigoUsuarioActionPerformed

    private void jButton_buscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscarUsuarioActionPerformed
        if (jTextField_codigoUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe llenar el campo a buscar");
        } else {
            obtenerUsuario();
        }
    }//GEN-LAST:event_jButton_buscarUsuarioActionPerformed

    private void jTextField_nombreTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombreTrabajoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nombreTrabajoActionPerformed

    private void jTextField_descripcionTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_descripcionTrabajoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_descripcionTrabajoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        super.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void llenarCombo() {
        ArrayList<String> fecha = new ArrayList<>();
        try {
            fecha = metodos.obtenerTrabajos();
            for (int i = 0; i < fecha.size(); i++) {
                jComboBox_trabajos.addItem(fecha.get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(verTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void obtenerInformacion() throws SQLException {
        ArrayList<String> informacion = new ArrayList<>();
        String fecha = (String) jComboBox_trabajos.getSelectedItem();
        informacion = metodos.obtenerInformacionTrabajo(fecha);
        jTextField_nombreTrabajo.setText(informacion.get(0));
        jTextField_descripcionTrabajo.setText(informacion.get(1));

    }

    public void obtenerUsuario() {
        String codigoUsuario = jTextField_codigoUsuario.getText();
        ArrayList<String> usuario = new ArrayList<>();
        if (isNumeric(codigoUsuario)) {
            try {
                usuario = metodos.obtenerUnicoUsuario(codigoUsuario);
            } catch (SQLException ex) {
                Logger.getLogger(registrarAsistenciasReuniones.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                usuario = metodos.obtenerUsuarios(codigoUsuario);
            } catch (SQLException ex) {
                Logger.getLogger(registrarAsistenciasReuniones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!usuario.isEmpty()) {
            DefaultTableModel modelo;
            modelo = new DefaultTableModel() {
                public boolean isCellEditable(int filas, int columnas) {
                    return false;
                }
            };
            modelo.addColumn("Nombre");
            jTable_usuarios.setModel(modelo);
            for (int i = 0; i < usuario.size(); i++) {
                modelo.addRow(new Object[]{usuario.get(i)});
            }

        } else {
            JOptionPane.showMessageDialog(null, "Usuario no registrado");
        }
    }

    public void obtenerUsuarios() throws SQLException {
        ArrayList<String> usuarios = new ArrayList<>();
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(){
            public boolean isCellEditable(int filas, int columnas) {
                return false;
            }
        };
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        jTable_usuarios.setModel(modelo);
        for (int i = 0; i < usuarios.size() - 1; i = i + 2) {
            modelo.addRow(new Object[]{usuarios.get(i), usuarios.get(i + 1)});
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                crearReunion dialog = new crearReunion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_asistencias;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_agregarUsuario;
    private javax.swing.JButton jButton_buscarUsuario;
    private javax.swing.JComboBox<String> jComboBox_trabajos;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_fechaReunion;
    private javax.swing.JLabel jLabel_nombreReunion;
    private javax.swing.JLabel jLabel_nombreReunion1;
    private javax.swing.JLabel jLabel_reunion;
    private javax.swing.JLabel jLabel_reunion2;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable_usuarios;
    private javax.swing.JTextField jTextField_codigoUsuario;
    private javax.swing.JTextField jTextField_descripcionTrabajo;
    private javax.swing.JTextField jTextField_nombreTrabajo;
    // End of variables declaration//GEN-END:variables
}
