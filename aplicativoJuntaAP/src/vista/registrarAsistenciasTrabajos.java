package vista;

import aplicativojuntaap.metodos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.manejador;
import static vista.registrarAsistenciasReuniones.isNumeric;

public class registrarAsistenciasTrabajos extends javax.swing.JDialog {

    public metodos metodos = new metodos();

    public registrarAsistenciasTrabajos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        setTitle("Registar Asistencias Trabajos");
        setLocationRelativeTo(null);
        llenarCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        buttonGroup_asistencias = new javax.swing.ButtonGroup();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel_titulo = new javax.swing.JLabel();
        jLabel_fechaReunion = new javax.swing.JLabel();
        jLabel_reunion3 = new javax.swing.JLabel();
        jComboBox_trabajos = new javax.swing.JComboBox<String>();
        jLabel_reunion = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jComboBox_nombreTrabajos = new javax.swing.JTextField();
        jLabel_nombreReunion2 = new javax.swing.JLabel();
        jLabel_reunion2 = new javax.swing.JLabel();
        jTextField_descripcionReunion = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jRadioButton_Asiste = new javax.swing.JRadioButton();
        jRadioButton_Falta = new javax.swing.JRadioButton();
        jButton_guardarAsistencia = new javax.swing.JButton();
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
        setPreferredSize(new java.awt.Dimension(797, 536));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 750, 10));

        jLabel_titulo.setFont(new java.awt.Font("Microsoft JhengHei", 1, 30)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(28, 108, 171));
        jLabel_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_titulo.setText("Registrar Asistencias Trabajos");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 750, -1));

        jLabel_fechaReunion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_fechaReunion.setText("Seleccione un trabajo por su fecha");
        getContentPane().add(jLabel_fechaReunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 30));

        jLabel_reunion3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jLabel_reunion3.setForeground(new java.awt.Color(28, 108, 171));
        jLabel_reunion3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_reunion3.setText("Socios Convocados");
        getContentPane().add(jLabel_reunion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 570, 30));

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
        getContentPane().add(jComboBox_trabajos, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 400, -1));

        jLabel_reunion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_reunion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_reunion.setText("Nombre del Trabajo");
        getContentPane().add(jLabel_reunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 165, 30));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 17, 160));

        jComboBox_nombreTrabajos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox_nombreTrabajos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_nombreTrabajosActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_nombreTrabajos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 468, -1));

        jLabel_nombreReunion2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel_nombreReunion2.setText("Seleccione el socio que desea*.");
        getContentPane().add(jLabel_nombreReunion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 260, 43));

        jLabel_reunion2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_reunion2.setText("Descripción del Trabajo");
        getContentPane().add(jLabel_reunion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 190, 30));

        jTextField_descripcionReunion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_descripcionReunion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_descripcionReunionActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_descripcionReunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 468, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 750, 13));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 260, 560, 180));

        buttonGroup_asistencias.add(jRadioButton_Asiste);
        jRadioButton_Asiste.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton_Asiste.setText("Asiste");
        jRadioButton_Asiste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_AsisteActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton_Asiste, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, -1, -1));

        buttonGroup_asistencias.add(jRadioButton_Falta);
        jRadioButton_Falta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton_Falta.setText("Falta");
        jRadioButton_Falta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_FaltaActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton_Falta, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, -1, -1));

        jButton_guardarAsistencia.setBackground(new java.awt.Color(0, 97, 155));
        jButton_guardarAsistencia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_guardarAsistencia.setForeground(new java.awt.Color(255, 255, 255));
        jButton_guardarAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        jButton_guardarAsistencia.setText("Guardar");
        jButton_guardarAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardarAsistenciaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_guardarAsistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, 125, 39));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 750, 420));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/texturas-pared-gris-fondo_74190-4389 (1).jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_trabajosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_trabajosActionPerformed
    }//GEN-LAST:event_jComboBox_trabajosActionPerformed

    private void jComboBox_nombreTrabajosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_nombreTrabajosActionPerformed
    }//GEN-LAST:event_jComboBox_nombreTrabajosActionPerformed

    private void jTextField_descripcionReunionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_descripcionReunionActionPerformed
    }//GEN-LAST:event_jTextField_descripcionReunionActionPerformed

    private void jButton_guardarAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardarAsistenciaActionPerformed
        jRadioButton_Asiste.setActionCommand("Asiste");
        jRadioButton_Falta.setActionCommand("Falta");
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        int fila = jTable1.getSelectedRow();
        int id = 0, asistencia = 1;
        String nombres, registro;
        String fecha = (String) jComboBox_trabajos.getSelectedItem();
        manejador mn = new manejador();
        if (fila >= 0) {
            nombres = String.valueOf(tm.getValueAt(jTable1.getSelectedRow(), 0));
            registro = buttonGroup_asistencias.getSelection().getActionCommand();
            try {
                id = Integer.parseInt(metodos.obtenerID(nombres));
            } catch (SQLException ex) {
                Logger.getLogger(registrarAsistenciasTrabajos.class.getName()).log(Level.SEVERE, null, ex);
            }
            if ("Falta".equals(registro)) {
                asistencia = 0;
            }
            try {
                metodos.actualizarUsuarioConvocado(fecha, id, asistencia);
                JOptionPane.showMessageDialog(this, "Registro Existoso !");
            } catch (SQLException ex) {
                Logger.getLogger(registrarAsistenciasTrabajos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton_guardarAsistenciaActionPerformed

    public void llenarCombo() {
        ArrayList<String> fecha = new ArrayList<>();
        try {
            fecha = metodos.obtenerTrabajos();
            for (int i = 0; i < fecha.size(); i++) {
                jComboBox_trabajos.addItem(fecha.get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(verReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void obtenerInformacion() throws SQLException {
        ArrayList<String> informacion = new ArrayList<>();
        ArrayList<String> usuarios = new ArrayList<>();
        String fecha = (String) jComboBox_trabajos.getSelectedItem();
        informacion = metodos.obtenerInformacionTrabajo(fecha);
        jComboBox_nombreTrabajos.setText(informacion.get(0));
        jTextField_descripcionReunion.setText(informacion.get(1));
        usuarios = metodos.ObtenerUsuariosConvocados(fecha);
        mostrarUsuarios(usuarios);

    }

    public void mostrarUsuarios(ArrayList usu) throws SQLException {
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(){
            public boolean isCellEditable(int filas, int columnas) {
                return false;
            }
        };
        modelo.addColumn("Nombres");
        jTable1.setModel(modelo);
        for (int i = 0; i < usu.size(); i++) {
            modelo.addRow(new Object[]{usu.get(i)});
        }
    }

    private void jComboBox_trabajosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_trabajosItemStateChanged
        try {
            obtenerInformacion();
        } catch (SQLException ex) {
            Logger.getLogger(verReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox_trabajosItemStateChanged

    private void jRadioButton_AsisteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_AsisteActionPerformed
    }//GEN-LAST:event_jRadioButton_AsisteActionPerformed

    private void jRadioButton_FaltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_FaltaActionPerformed
    }//GEN-LAST:event_jRadioButton_FaltaActionPerformed

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
    private javax.swing.JButton jButton_guardarAsistencia;
    private javax.swing.JTextField jComboBox_nombreTrabajos;
    private javax.swing.JComboBox<String> jComboBox_trabajos;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_fechaReunion;
    private javax.swing.JLabel jLabel_nombreReunion2;
    private javax.swing.JLabel jLabel_reunion;
    private javax.swing.JLabel jLabel_reunion2;
    private javax.swing.JLabel jLabel_reunion3;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JRadioButton jRadioButton_Asiste;
    private javax.swing.JRadioButton jRadioButton_Falta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField_descripcionReunion;
    // End of variables declaration//GEN-END:variables
}
