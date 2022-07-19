package vista;

import aplicativojuntaap.metodos;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class informacionReuniones extends javax.swing.JDialog {

    metodos metodos = new metodos();

    public informacionReuniones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        setTitle("Información de Reuniones");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel_titulo = new javax.swing.JLabel();
        jButton_crearReunion2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel_nombreReunion1 = new javax.swing.JLabel();
        jTextField_codigoUsuario = new javax.swing.JTextField();
        jButton_buscarUsuario = new javax.swing.JButton();
        jLabel_nombreReunion2 = new javax.swing.JLabel();
        jTextField_nombres = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_verTrabajos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

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
        setPreferredSize(new java.awt.Dimension(785, 595));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(28, 108, 171));
        jLabel_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_titulo.setText("Información de Reuniones");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 750, -1));

        jButton_crearReunion2.setBackground(new java.awt.Color(0, 97, 155));
        jButton_crearReunion2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_crearReunion2.setForeground(new java.awt.Color(255, 255, 255));
        jButton_crearReunion2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tick.png"))); // NOI18N
        jButton_crearReunion2.setText("Aceptar");
        jButton_crearReunion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_crearReunion2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_crearReunion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 490, 180, 39));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 710, 20));

        jLabel_nombreReunion1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_nombreReunion1.setText("Ingrese el código del usuario a buscar");
        getContentPane().add(jLabel_nombreReunion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 30));

        jTextField_codigoUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_codigoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_codigoUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_codigoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 98, 570, 40));

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
        getContentPane().add(jButton_buscarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 131, 39));

        jLabel_nombreReunion2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_nombreReunion2.setText("Nombre:");
        getContentPane().add(jLabel_nombreReunion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 43));

        jTextField_nombres.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_nombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombresActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 630, -1));

        jTable_verTrabajos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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
                "Fecha", "Reunión", "Estado"
            }
        ));
        jTable_verTrabajos.setAutoscrolls(false);
        jTable_verTrabajos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTable_verTrabajos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 727, 277));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 750, 490));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/texturas-pared-gris-fondo_74190-4389 (1).jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_codigoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_codigoUsuarioActionPerformed
        if (jTextField_codigoUsuario.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Debe Ingresar el Codigo del Usuario");
        } else {
            if (isNumeric(jTextField_codigoUsuario.getText())) {
                ArrayList<String> valores = new ArrayList<>();
                ArrayList<String> socio = new ArrayList<>();
                int codigo = Integer.parseInt(jTextField_codigoUsuario.getText());
                try {
                    socio = metodos.verSocioC(Integer.parseInt(jTextField_codigoUsuario.getText()));
                    if (socio.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Usuario no Registrado");
                    } else {
                        valores = metodos.informacionSocioReunion(codigo);
                        jTextField_nombres.setText(valores.get(0));
                        DefaultTableModel modelo;
                        modelo = new DefaultTableModel() {
                            public boolean isCellEditable(int filas, int columnas) {
                                return false;
                            }
                        };
                        modelo.addColumn("Fecha");
                        modelo.addColumn("Nombre Reunion");
                        modelo.addColumn("Estado");
                        jTable_verTrabajos.setModel(modelo);
                        for (int i = 1; i < valores.size() - 2; i = i + 3) {
                            modelo.addRow(new Object[]{valores.get(i), valores.get(i + 1), valores.get(i + 2)});
                        }
                    }
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(informacionReuniones.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "ID no válido");
            }
        }
    }//GEN-LAST:event_jTextField_codigoUsuarioActionPerformed

    private void jButton_buscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscarUsuarioActionPerformed
        if (jTextField_codigoUsuario.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Debe Ingresar el Codigo del Usuario");
        } else {
            if (isNumeric(jTextField_codigoUsuario.getText())) {
                ArrayList<String> valores = new ArrayList<>();
                ArrayList<String> socio = new ArrayList<>();
                int codigo = Integer.parseInt(jTextField_codigoUsuario.getText());
                try {
                    socio = metodos.verSocioC(Integer.parseInt(jTextField_codigoUsuario.getText()));
                    if (socio.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Usuario no Registrado");
                    } else {
                        valores = metodos.informacionSocioReunion(codigo);
                        jTextField_nombres.setText(valores.get(0));
                        DefaultTableModel modelo;
                        modelo = new DefaultTableModel() {
                            public boolean isCellEditable(int filas, int columnas) {
                                return false;
                            }
                        };
                        modelo.addColumn("Fecha");
                        modelo.addColumn("Nombre Reunion");
                        modelo.addColumn("Estado");
                        jTable_verTrabajos.setModel(modelo);
                        for (int i = 1; i < valores.size() - 2; i = i + 3) {
                            modelo.addRow(new Object[]{valores.get(i), valores.get(i + 1), valores.get(i + 2)});
                        }
                    }
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(informacionReuniones.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "ID no válido");
            }
        }
    }//GEN-LAST:event_jButton_buscarUsuarioActionPerformed

    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    private void jTextField_nombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombresActionPerformed
    }//GEN-LAST:event_jTextField_nombresActionPerformed

    private void jButton_crearReunion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_crearReunion2ActionPerformed
        super.dispose();
    }//GEN-LAST:event_jButton_crearReunion2ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(informacionReuniones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
    private javax.swing.JButton jButton_buscarUsuario;
    private javax.swing.JButton jButton_crearReunion2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_nombreReunion1;
    private javax.swing.JLabel jLabel_nombreReunion2;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable_verTrabajos;
    private javax.swing.JTextField jTextField_codigoUsuario;
    private javax.swing.JTextField jTextField_nombres;
    // End of variables declaration//GEN-END:variables
}
