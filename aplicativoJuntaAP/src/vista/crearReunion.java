package vista;

import aplicativojuntaap.metodos;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.asistenciaReunion;
import logica.manejador;
import logica.reunion;

public class crearReunion extends javax.swing.JDialog {

    manejador mn = new manejador();

    public crearReunion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Crear Reunión");
        this.setResizable(false);
        setTitle("Crear Reunión");
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
        jTextField_ingresarNombreReunion = new javax.swing.JTextField();
        jLabel_descripcionReunion = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton_crearReunion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextField_ingresarDescripcionReunion = new javax.swing.JTextArea();
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
        setMaximumSize(new java.awt.Dimension(736, 462));
        setMinimumSize(new java.awt.Dimension(736, 462));
        setPreferredSize(new java.awt.Dimension(745, 470));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(28, 108, 171));
        jLabel_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_titulo.setText("Crear Reunión");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 11, 700, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 48, 700, 10));

        jLabel_fechaReunion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_fechaReunion.setForeground(new java.awt.Color(0, 45, 62));
        jLabel_fechaReunion.setText("Ingrese fecha de la reunión");
        getContentPane().add(jLabel_fechaReunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 77, 250, 27));

        jDateChooser_selectorFechaTrabajo.setDateFormatString("yyyy-MM-dd");
        jDateChooser_selectorFechaTrabajo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        getContentPane().add(jDateChooser_selectorFechaTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 110, 680, 30));

        jLabel_nombreReunion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_nombreReunion.setForeground(new java.awt.Color(0, 45, 62));
        jLabel_nombreReunion.setText("Asunto de la reunión");
        getContentPane().add(jLabel_nombreReunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 676, -1));

        jTextField_ingresarNombreReunion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_ingresarNombreReunion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField_ingresarNombreReunion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_ingresarNombreReunionActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_ingresarNombreReunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 676, 30));

        jLabel_descripcionReunion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_descripcionReunion.setForeground(new java.awt.Color(0, 45, 62));
        jLabel_descripcionReunion.setText("Comentarios");
        getContentPane().add(jLabel_descripcionReunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 220, 599, -1));

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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 380, 130, 40));

        jButton_crearReunion.setBackground(new java.awt.Color(0, 97, 155));
        jButton_crearReunion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_crearReunion.setForeground(new java.awt.Color(255, 255, 255));
        jButton_crearReunion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add (1).png"))); // NOI18N
        jButton_crearReunion.setText("Crear Reunión");
        jButton_crearReunion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_crearReunionActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_crearReunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 180, 39));

        jTextField_ingresarDescripcionReunion.setColumns(20);
        jTextField_ingresarDescripcionReunion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_ingresarDescripcionReunion.setRows(5);
        jTextField_ingresarDescripcionReunion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(jTextField_ingresarDescripcionReunion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 680, 110));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 700, 370));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/texturas-pared-gris-fondo_74190-4389 (1).jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_crearReunionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_crearReunionActionPerformed
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
        String nombreReunion = jTextField_ingresarNombreReunion.getText();
        String descripcionReunion = jTextField_ingresarDescripcionReunion.getText();
        if (jTextField_ingresarNombreReunion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Llenar el campo Nombre");
            cont++;
        }
        if (jTextField_ingresarDescripcionReunion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Llenar el campo Descripcion");
            cont++;
        }

        if (cont == 0) {
            reunion crearReunion = mn.crearReunion(fecha, nombreReunion, descripcionReunion);
            metodos mt = new metodos();

            try {
                mt.crearReunion(crearReunion);
                mt.crearAsistenciasReuniones(fecha);
            } catch (SQLException ex) {
                Logger.getLogger(crearReunion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton_crearReunionActionPerformed

    private void jTextField_ingresarNombreReunionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_ingresarNombreReunionActionPerformed
    }//GEN-LAST:event_jTextField_ingresarNombreReunionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        super.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;

    }

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
            java.util.logging.Logger.getLogger(crearReunion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton jButton_crearReunion;
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
    private javax.swing.JTextArea jTextField_ingresarDescripcionReunion;
    private javax.swing.JTextField jTextField_ingresarNombreReunion;
    // End of variables declaration//GEN-END:variables
}
