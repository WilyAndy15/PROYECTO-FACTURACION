package vista;

import aplicativojuntaap.metodos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class informacionTrabajos extends javax.swing.JDialog {

    public metodos metodos = new metodos();

    public informacionTrabajos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setResizable(false);
        initComponents();
        setTitle("Información de Trabajos");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel_titulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton_crearReunion2 = new javax.swing.JButton();
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Microsoft JhengHei", 1, 30)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(28, 108, 171));
        jLabel_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_titulo.setText("Información Trabajos");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 750, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 42, 750, 10));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 720, 20));

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
        getContentPane().add(jButton_crearReunion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 480, 180, 39));

        jLabel_nombreReunion1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_nombreReunion1.setText("Ingrese el código del usuario a buscar");
        getContentPane().add(jLabel_nombreReunion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 43));

        jTextField_codigoUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_codigoUsuario.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTextField_codigoUsuarioAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTextField_codigoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_codigoUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_codigoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 98, 570, 40));

        jButton_buscarUsuario.setBackground(new java.awt.Color(30, 139, 204));
        jButton_buscarUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_buscarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jButton_buscarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        jButton_buscarUsuario.setText("Buscar");
        jButton_buscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_buscarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 131, 39));

        jLabel_nombreReunion2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_nombreReunion2.setText("Nombres:");
        getContentPane().add(jLabel_nombreReunion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 43));

        jTextField_nombres.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_nombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombresActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 620, -1));

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
                "Fecha", "Trabajo", "Estado"
            }
        ));
        jTable_verTrabajos.setAutoscrolls(false);
        jTable_verTrabajos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTable_verTrabajos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 727, 270));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 750, 470));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/texturas-pared-gris-fondo_74190-4389 (1).jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_codigoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_codigoUsuarioActionPerformed
    }//GEN-LAST:event_jTextField_codigoUsuarioActionPerformed

    private void jButton_buscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscarUsuarioActionPerformed
        try {
            if(jTextField_codigoUsuario.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Debe Ingresar el Socio");
            }
            else{
                obtenerUsuario();
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(registrarAsistenciasReuniones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_buscarUsuarioActionPerformed

    private void jTextField_nombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombresActionPerformed
    }//GEN-LAST:event_jTextField_nombresActionPerformed

    private void jButton_crearReunion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_crearReunion2ActionPerformed
        super.dispose();
    }//GEN-LAST:event_jButton_crearReunion2ActionPerformed

    private void jTextField_codigoUsuarioAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTextField_codigoUsuarioAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_codigoUsuarioAncestorAdded

    public void obtenerUsuario() throws SQLException {
        String idUsuario = jTextField_codigoUsuario.getText();
        ArrayList<String> usuario = metodos.obtenerUnicoUsuario(idUsuario);
        if(usuario.isEmpty()){
            JOptionPane.showMessageDialog(this, "Usuario No Registrado");
        }else{
            jTextField_nombres.setText(usuario.get(0));
            obtenerRegistrosNombres();
        }
        

    }

    public void obtenerRegistrosNombres() throws SQLException {
        String idUsuario = jTextField_codigoUsuario.getText();
        ArrayList<String> usuarios = metodos.informacionSocioTrabajo(idUsuario);
        DefaultTableModel modelo;
        modelo = new DefaultTableModel();
        modelo.addColumn("Fecha");
        modelo.addColumn("Trabajo");
        modelo.addColumn("Estado");
        jTable_verTrabajos.setModel(modelo);
        for (int i = 0; i < usuarios.size() - 2; i = i + 3) {
            modelo.addRow(new Object[]{usuarios.get(i), usuarios.get(i + 1),usuarios.get(i + 2)});
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
            java.util.logging.Logger.getLogger(informacionTrabajos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable_verTrabajos;
    private javax.swing.JTextField jTextField_codigoUsuario;
    private javax.swing.JTextField jTextField_nombres;
    // End of variables declaration//GEN-END:variables
}
