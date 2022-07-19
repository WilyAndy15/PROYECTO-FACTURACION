
package vista;

import aplicativojuntaap.metodos;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.manejador;
import logica.reunion;
import logica.trabajo;

public class crearTrabajo extends javax.swing.JDialog {

    public crearTrabajo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        setTitle("Crear Trabajo");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel_titulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel_fechaReunion = new javax.swing.JLabel();
        jDateChooser_selectorFechaTrabajo = new com.toedter.calendar.JDateChooser();
        jLabel_nombreReunion = new javax.swing.JLabel();
        jTextField_ingresarNombreTrabajo = new javax.swing.JTextField();
        jLabel_descripcionReunion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextField_ingresarDescripcionTrabajo = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton_crearTrabajo = new javax.swing.JButton();
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
        setPreferredSize(new java.awt.Dimension(605, 451));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(28, 108, 171));
        jLabel_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_titulo.setText("Crear Trabajo");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 580, 10));

        jLabel_fechaReunion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_fechaReunion.setText("Ingrese fecha del trabajo");
        getContentPane().add(jLabel_fechaReunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 549, -1));

        jDateChooser_selectorFechaTrabajo.setDateFormatString("yyyy-MM-dd");
        jDateChooser_selectorFechaTrabajo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jDateChooser_selectorFechaTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 549, 27));

        jLabel_nombreReunion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_nombreReunion.setText("Ingrese el nombre del trabajo");
        getContentPane().add(jLabel_nombreReunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 548, -1));

        jTextField_ingresarNombreTrabajo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_ingresarNombreTrabajo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField_ingresarNombreTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_ingresarNombreTrabajoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_ingresarNombreTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 547, -1));

        jLabel_descripcionReunion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_descripcionReunion.setText("Ingrese la descripción del trabajo");
        getContentPane().add(jLabel_descripcionReunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 548, -1));

        jTextField_ingresarDescripcionTrabajo.setColumns(20);
        jTextField_ingresarDescripcionTrabajo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_ingresarDescripcionTrabajo.setRows(5);
        jScrollPane1.setViewportView(jTextField_ingresarDescripcionTrabajo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 540, 100));

        jButton1.setBackground(new java.awt.Color(203, 23, 12));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 130, 40));

        jButton_crearTrabajo.setBackground(new java.awt.Color(0, 97, 155));
        jButton_crearTrabajo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_crearTrabajo.setForeground(new java.awt.Color(255, 255, 255));
        jButton_crearTrabajo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add (1).png"))); // NOI18N
        jButton_crearTrabajo.setText("Crear Trabajo");
        jButton_crearTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_crearTrabajoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_crearTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, -1, 39));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 580, 350));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/texturas-pared-gris-fondo_74190-4389 (1).jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_crearTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_crearTrabajoActionPerformed
        // TODO add your handling code here:
        int cont = 0;
        int ano = 0, mes = 0, dia = 0;
        if (jDateChooser_selectorFechaTrabajo.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una Fecha");
            cont++;
        } else {
            ano = jDateChooser_selectorFechaTrabajo.getCalendar().get(Calendar.YEAR);
            mes = jDateChooser_selectorFechaTrabajo.getCalendar().get(Calendar.MONTH) + 1;
            dia = jDateChooser_selectorFechaTrabajo.getCalendar().get(Calendar.DAY_OF_MONTH);
        }
        String fecha = ano + "-" + mes + "-" + dia;
        String nombreTrabajo = jTextField_ingresarNombreTrabajo.getText();
        String descripcionTrabajo = jTextField_ingresarDescripcionTrabajo.getText();
        if (jTextField_ingresarNombreTrabajo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Llenar el campo Nombre");
            cont++;
        }
        if (jTextField_ingresarDescripcionTrabajo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Llenar el campo Descripcion");
            cont++;
        }
        if (cont == 0) {
            try {
                manejador mn = new manejador();
                trabajo crearTrabajo = mn.crearTrabajo(fecha, nombreTrabajo, descripcionTrabajo);
                metodos mt = new metodos();
                mt.crearTrabajo(crearTrabajo);
                this.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(crearTrabajo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton_crearTrabajoActionPerformed

    private void jTextField_ingresarNombreTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_ingresarNombreTrabajoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_ingresarNombreTrabajoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        super.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crearTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton jButton_crearTrabajo;
    private com.toedter.calendar.JDateChooser jDateChooser_selectorFechaTrabajo;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_descripcionReunion;
    private javax.swing.JLabel jLabel_fechaReunion;
    private javax.swing.JLabel jLabel_nombreReunion;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextField_ingresarDescripcionTrabajo;
    private javax.swing.JTextField jTextField_ingresarNombreTrabajo;
    // End of variables declaration//GEN-END:variables
}
