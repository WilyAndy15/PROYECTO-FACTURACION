package vista;

import aplicativojuntaap.metodos;
import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class informacionSocios1 extends javax.swing.JDialog {

    metodos metodos = new metodos();

    DefaultTableModel modelo;

    public informacionSocios1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        setTitle("Información de Socios");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel_titulo = new javax.swing.JLabel();
        jButton_crearReunion2 = new javax.swing.JButton();
        jLabel_nombreReunion7 = new javax.swing.JLabel();
        jTextField_codigoUsuario1 = new javax.swing.JTextField();
        jButton_buscarUsuario1 = new javax.swing.JButton();
        nombre = new javax.swing.JTextField();
        jLabel_nombreReunion8 = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        jLabel_nombreReunion9 = new javax.swing.JLabel();
        jLabel_nombreReunion10 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        jLabel_nombreReunion11 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        jLabel_nombreReunion12 = new javax.swing.JLabel();
        medidor = new javax.swing.JTextField();
        jLabel_nombreReunion13 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPersonas = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
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
        setPreferredSize(new java.awt.Dimension(768, 655));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Microsoft JhengHei", 1, 30)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(28, 108, 171));
        jLabel_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_titulo.setText("Información de Socios");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 720, -1));

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
        getContentPane().add(jButton_crearReunion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 560, 180, 39));

        jLabel_nombreReunion7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_nombreReunion7.setText("Ingrese el código o nombre del usuario a buscar");
        getContentPane().add(jLabel_nombreReunion7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 390, -1));

        jTextField_codigoUsuario1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_codigoUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_codigoUsuario1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_codigoUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 530, 40));

        jButton_buscarUsuario1.setBackground(new java.awt.Color(30, 139, 204));
        jButton_buscarUsuario1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_buscarUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        jButton_buscarUsuario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loupe.png"))); // NOI18N
        jButton_buscarUsuario1.setText("Buscar");
        jButton_buscarUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscarUsuario1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_buscarUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 131, 40));

        nombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 510, -1));

        jLabel_nombreReunion8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_nombreReunion8.setText("Nombre");
        getContentPane().add(jLabel_nombreReunion8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 180, 30));

        cedula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaActionPerformed(evt);
            }
        });
        getContentPane().add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 510, -1));

        jLabel_nombreReunion9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_nombreReunion9.setText("Cédula");
        getContentPane().add(jLabel_nombreReunion9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 180, 30));

        jLabel_nombreReunion10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_nombreReunion10.setText("Teléfono");
        getContentPane().add(jLabel_nombreReunion10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 170, 30));

        correo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoActionPerformed(evt);
            }
        });
        getContentPane().add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 510, -1));

        jLabel_nombreReunion11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_nombreReunion11.setText("Correo Electrónico");
        getContentPane().add(jLabel_nombreReunion11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, -1, 28));

        telefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoActionPerformed(evt);
            }
        });
        getContentPane().add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 510, -1));

        jLabel_nombreReunion12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_nombreReunion12.setText("Num. medidor");
        getContentPane().add(jLabel_nombreReunion12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 170, 30));

        medidor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        medidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medidorActionPerformed(evt);
            }
        });
        getContentPane().add(medidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 510, -1));

        jLabel_nombreReunion13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_nombreReunion13.setText("Codigo");
        getContentPane().add(jLabel_nombreReunion13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 180, 30));

        codigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });
        getContentPane().add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 510, -1));

        TablaPersonas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TablaPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Codigo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaPersonas.setFocusable(false);
        TablaPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaPersonasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaPersonas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 671, 160));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 671, 10));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 720, 560));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/texturas-pared-gris-fondo_74190-4389 (1).jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_codigoUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_codigoUsuario1ActionPerformed
        int cont = 0;
        if (jTextField_codigoUsuario1.getText().isEmpty()) {
            cont++;
            JOptionPane.showMessageDialog(this, "Debe ingresar el Socio a buscar");
        }
        if (cont == 0) {
            try {

                // boton para llenar en la base
                ArrayList Resultados = new ArrayList();
                metodos m = new metodos();
                String nombre = jTextField_codigoUsuario1.getText();
                if (isNumeric(nombre)) {
                    Resultados = m.obtenerInformacionSocioCod(nombre);
                } else {
                    Resultados = m.obtenerInformacionSocioNombre(nombre);
                }
                if(!Resultados.isEmpty()){
                    llenarTabla(Resultados);
                }else{
                JOptionPane.showMessageDialog(this, "Socio no Encontrado");
                }
               
            } catch (SQLException | IOException ex) {
                Logger.getLogger(realizarCobros1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextField_codigoUsuario1ActionPerformed

    private void jButton_buscarUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscarUsuario1ActionPerformed
        // TODO add your handling code here:
        int cont = 0;
        if (jTextField_codigoUsuario1.getText().isEmpty()) {
            cont++;
            JOptionPane.showMessageDialog(this, "Debe ingresar el Socio a buscar");
        }
        if (cont == 0) {
            try {

                // boton para llenar en la base
                ArrayList Resultados = new ArrayList();
                metodos m = new metodos();
                String nombre = jTextField_codigoUsuario1.getText();
                if (isNumeric(nombre)) {
                    Resultados = m.obtenerInformacionSocioCod(nombre);
                } else {
                    Resultados = m.obtenerInformacionSocioNombre(nombre);
                }
                if(!Resultados.isEmpty()){
                    llenarTabla(Resultados);
                }else{
                JOptionPane.showMessageDialog(this, "Socio no Encontrado");
                }
               
            } catch (SQLException | IOException ex) {
                Logger.getLogger(realizarCobros1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton_buscarUsuario1ActionPerformed

    public void llenarTabla(ArrayList Resultados) {
        modelo = new DefaultTableModel() {
            public boolean isCellEditable(int filas, int columnas) {
                if (columnas == 2) {
                    return true;
                } else {
                    return false;
                }
            }
            //modelo.getColumnModel().getColumn(0).setPreferredWidth(20);
        };

        modelo.addColumn("Nombre");
        modelo.addColumn("Codigo");

        TablaPersonas.setModel(modelo);
        for (int i = 0; i < Resultados.size() - 1; i += 2) {
            modelo.addRow(new Object[]{Resultados.get(i + 1), Resultados.get(i)});
            // System.out.println(valores.get(i));
        }
    }

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


    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaActionPerformed

    private void correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correoActionPerformed

    private void telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoActionPerformed

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed

    private void medidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medidorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medidorActionPerformed

    private void TablaPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPersonasMouseClicked
        // TODO add your handling code here:
        String strResultado = modelo.getValueAt(TablaPersonas.getSelectedRow(), TablaPersonas.getSelectedColumn()).toString();
        ArrayList Resultados = new ArrayList();
        try {
            Resultados = metodos.verSocioN(strResultado);
            codigo.setText(Integer.toString((int) Resultados.get(0)));
            medidor.setText((Integer.toString((int) Resultados.get(1))));
            nombre.setText((String) Resultados.get(2));
            cedula.setText((String) Resultados.get(3));
            telefono.setText((String) Resultados.get(4));
            correo.setText((String) Resultados.get(5));
        } catch (SQLException ex) {
            Logger.getLogger(informacionSocios1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(informacionSocios1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_TablaPersonasMouseClicked

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
            java.util.logging.Logger.getLogger(informacionSocios1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JTable TablaPersonas;
    private javax.swing.JTextField cedula;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField correo;
    private javax.swing.JButton jButton_buscarUsuario1;
    private javax.swing.JButton jButton_crearReunion2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_nombreReunion10;
    private javax.swing.JLabel jLabel_nombreReunion11;
    private javax.swing.JLabel jLabel_nombreReunion12;
    private javax.swing.JLabel jLabel_nombreReunion13;
    private javax.swing.JLabel jLabel_nombreReunion7;
    private javax.swing.JLabel jLabel_nombreReunion8;
    private javax.swing.JLabel jLabel_nombreReunion9;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField_codigoUsuario1;
    private javax.swing.JTextField medidor;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
