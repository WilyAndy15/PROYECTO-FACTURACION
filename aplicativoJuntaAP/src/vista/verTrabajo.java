package vista;

import aplicativojuntaap.metodos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class verTrabajo extends javax.swing.JDialog {

    public metodos metodos = new metodos();

    public verTrabajo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setResizable(false);
        initComponents();
        setTitle("Ver Trabajos");
        setLocationRelativeTo(null);
        llenarCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel_titulo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_verTrabajos = new javax.swing.JTable();
        jLabel = new javax.swing.JLabel();
        jComboBox_trabajos = new javax.swing.JComboBox<String>();
        jLabel_reunion = new javax.swing.JLabel();
        jLabel_reunion2 = new javax.swing.JLabel();
        jTextField_nombreTrabajo = new javax.swing.JTextField();
        jTextField_descripcionTrabajo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(28, 108, 171));
        jLabel_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_titulo.setText("Ver Trabajo");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1000, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1000, 10));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 990, 10));

        jTable_verTrabajos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable_verTrabajos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombres", "Apellidos", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTable_verTrabajos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 964, 230));

        jLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel.setText("Seleccione un trabajo");
        getContentPane().add(jLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

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
        getContentPane().add(jComboBox_trabajos, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 70, 790, -1));

        jLabel_reunion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_reunion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_reunion.setText("Nombre del Trabajo");
        getContentPane().add(jLabel_reunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));

        jLabel_reunion2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_reunion2.setText("Descripción Trabajo");
        getContentPane().add(jLabel_reunion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 165, 30));

        jTextField_nombreTrabajo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_nombreTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombreTrabajoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_nombreTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 110, 790, -1));

        jTextField_descripcionTrabajo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_descripcionTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_descripcionTrabajoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_descripcionTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 150, 790, -1));

        jButton1.setBackground(new java.awt.Color(203, 23, 12));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        jButton1.setText("Eliminar Usuario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 490, -1, 40));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(28, 108, 171));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Personas Convocadas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 960, -1));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 58, 1000, 490));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/texturas-pared-gris-fondo_74190-4389 (1).jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_trabajosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_trabajosActionPerformed
    }//GEN-LAST:event_jComboBox_trabajosActionPerformed

    private void jTextField_nombreTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombreTrabajoActionPerformed
    }//GEN-LAST:event_jTextField_nombreTrabajoActionPerformed

    private void jTextField_descripcionTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_descripcionTrabajoActionPerformed
    }//GEN-LAST:event_jTextField_descripcionTrabajoActionPerformed

    private void jComboBox_trabajosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_trabajosItemStateChanged
        try {
            obtenerInformacion();
            obtenerRegistrosNombres();
        } catch (SQLException ex) {
            Logger.getLogger(verTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox_trabajosItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            DefaultTableModel tm = (DefaultTableModel) jTable_verTrabajos.getModel();
            String fecha = (String) jComboBox_trabajos.getSelectedItem();
            String nombres = String.valueOf(tm.getValueAt(jTable_verTrabajos.getSelectedRow(), 0));
            int id = Integer.parseInt(nombres);
            metodos.eliminarConvocado(fecha, id);
            JOptionPane.showMessageDialog(this, "Usuario Eliminado");
            obtenerInformacion();
            obtenerRegistrosNombres();
        } catch (SQLException ex) {
            Logger.getLogger(verTrabajo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Seleccione el ID del Uusario");
        }
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

    public void obtenerRegistrosNombres() throws SQLException {
        String fecha = (String) jComboBox_trabajos.getSelectedItem();
        ArrayList<String> usuarios = metodos.obtenerUsuariosConvocados(fecha);
        if (!usuarios.isEmpty()) {
            DefaultTableModel modelo;
            modelo = new DefaultTableModel() {
                public boolean isCellEditable(int filas, int columnas) {
                    return false;
                }
            };
            modelo.addColumn("ID Usuario");
            modelo.addColumn("Nombres y Apellidos");
            modelo.addColumn("Estado");
            jTable_verTrabajos.setModel(modelo);
            for (int i = 0; i < usuarios.size() - 2; i = i + 3) {
                modelo.addRow(new Object[]{usuarios.get(i), usuarios.get(i + 1), usuarios.get(i + 2)});
            }
        } else {
            DefaultTableModel modelo;
            modelo = new DefaultTableModel() {
                public boolean isCellEditable(int filas, int columnas) {
                    return false;
                }
            };
            modelo.addColumn("ID Usuario");
            modelo.addColumn("Nombres y Apellidos");
            modelo.addColumn("Estado");
            jTable_verTrabajos.setModel(modelo);

        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(verTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
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
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox_trabajos;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_reunion;
    private javax.swing.JLabel jLabel_reunion2;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable_verTrabajos;
    private javax.swing.JTextField jTextField_descripcionTrabajo;
    private javax.swing.JTextField jTextField_nombreTrabajo;
    // End of variables declaration//GEN-END:variables
}
