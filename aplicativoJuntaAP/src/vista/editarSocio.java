package vista;

import aplicativojuntaap.metodos;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.manejador;
import logica.socio;
import static vista.informacionSocios1.isNumeric;

public class editarSocio extends javax.swing.JDialog {

    metodos metodos = new metodos();
    manejador m = new manejador();
    public String fullPath;
    DefaultTableModel modelo;
    public static int id = 0;

    public editarSocio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        setTitle("Mantenimiento Socio");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel_titulo = new javax.swing.JLabel();
        jLabel_nombreSocio = new javax.swing.JLabel();
        jTextField_codigoUsuario1 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPersonas = new javax.swing.JTable();
        jLabel_cedulaSocio = new javax.swing.JLabel();
        jLabel_nombreSocio1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        nombre = new javax.swing.JTextField();
        jLabel_nombreSocio2 = new javax.swing.JLabel();
        medidor = new javax.swing.JTextField();
        jLabel_cedulaSocio1 = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        jLabel_telefonoSocio = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        jLabel_correoSocio = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        jButton_eliminarSocio = new javax.swing.JButton();
        consumoInicial = new javax.swing.JTextField();
        jButton_actualizarSocio = new javax.swing.JButton();
        jLabel_correoSocio1 = new javax.swing.JLabel();
        jButton_buscarUsuario1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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

        setPreferredSize(new java.awt.Dimension(744, 740));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Microsoft JhengHei", 1, 30)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(28, 108, 171));
        jLabel_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_titulo.setText("Mantenimiento Socios");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 700, -1));

        jLabel_nombreSocio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_nombreSocio.setText("Ingrese el código o nombre a buscar");
        getContentPane().add(jLabel_nombreSocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 326, 29));

        jTextField_codigoUsuario1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_codigoUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_codigoUsuario1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_codigoUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 118, 540, 40));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 660, 10));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 660, 130));

        jLabel_cedulaSocio.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 24)); // NOI18N
        jLabel_cedulaSocio.setForeground(new java.awt.Color(28, 108, 171));
        jLabel_cedulaSocio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_cedulaSocio.setText("Información");
        getContentPane().add(jLabel_cedulaSocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 570, 27));

        jLabel_nombreSocio1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_nombreSocio1.setText("Nombre");
        getContentPane().add(jLabel_nombreSocio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 146, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 696, 10));

        nombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 394, -1));

        jLabel_nombreSocio2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_nombreSocio2.setText("Num. Medidor");
        getContentPane().add(jLabel_nombreSocio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 132, 30));

        medidor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(medidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, 394, -1));

        jLabel_cedulaSocio1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_cedulaSocio1.setText("Cedula");
        getContentPane().add(jLabel_cedulaSocio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 78, 30));

        cedula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 394, -1));

        jLabel_telefonoSocio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_telefonoSocio.setText("Teléfono");
        getContentPane().add(jLabel_telefonoSocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 168, 28));

        telefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 394, -1));

        jLabel_correoSocio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_correoSocio.setText("Correo electrónico");
        getContentPane().add(jLabel_correoSocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 156, 28));

        correo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, 394, -1));

        jButton_eliminarSocio.setBackground(new java.awt.Color(203, 23, 12));
        jButton_eliminarSocio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_eliminarSocio.setForeground(new java.awt.Color(255, 255, 255));
        jButton_eliminarSocio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        jButton_eliminarSocio.setText("Eliminar Usuario");
        jButton_eliminarSocio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jButton_eliminarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarSocioActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_eliminarSocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 610, 220, 40));

        consumoInicial.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(consumoInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 560, 394, -1));

        jButton_actualizarSocio.setBackground(new java.awt.Color(0, 97, 155));
        jButton_actualizarSocio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_actualizarSocio.setForeground(new java.awt.Color(255, 255, 255));
        jButton_actualizarSocio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon Up.png"))); // NOI18N
        jButton_actualizarSocio.setText("Actualizar");
        jButton_actualizarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarSocioActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_actualizarSocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 610, -1, 40));

        jLabel_correoSocio1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_correoSocio1.setText("Consumo Inicial");
        getContentPane().add(jLabel_correoSocio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, 156, 28));

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
        getContentPane().add(jButton_buscarUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 121, 40));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 720, 590));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/texturas-pared-gris-fondo_74190-4389 (1).jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_buscarUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscarUsuario1ActionPerformed
        // TODO add your handling code here:
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
                if (!Resultados.isEmpty()) {
                    llenarTabla(Resultados);
                } else {
                    JOptionPane.showMessageDialog(this, "Socio no Registrado");
                }
            } catch (SQLException | IOException ex) {
                Logger.getLogger(realizarCobros1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton_buscarUsuario1ActionPerformed

    private void jButton_actualizarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarSocioActionPerformed
        // TODO add your handling code here:
        int cont = 0;
        int id = Integer.parseInt(modelo.getValueAt(TablaPersonas.getSelectedRow(), 1).toString());
        if (cedula.getText().isEmpty()) {
            cont++;
            JOptionPane.showMessageDialog(this, "Debe Ingresar una cedula");
        }
        if (nombre.getText().isEmpty()) {
            cont++;
            JOptionPane.showMessageDialog(this, "Debe Ingresar el Nombre");
        }
        if (medidor.getText().isEmpty()) {
            cont++;
            JOptionPane.showMessageDialog(this, "Debe Ingresar un numero de Medidor");
        }
        if (telefono.getText().isEmpty()) {
            cont++;
            JOptionPane.showMessageDialog(this, "Debe Ingresar un numero de telefono o celular");
        }
        if (consumoInicial.getText().isEmpty()) {
            cont++;
            JOptionPane.showMessageDialog(this, "Debe Ingresar el consumo inicial");
        }
        if (cont == 0) {
            String nomb = nombre.getText();
            int med = Integer.parseInt(medidor.getText());
            String ced = cedula.getText();
            String tel = telefono.getText();
            String cor = correo.getText();
            if (isNumero(consumoInicial.getText())) {
                double cons = Double.parseDouble(consumoInicial.getText());
                socio s = new socio(id, med, nomb, ced, tel, cor, cons);
                try {
                    metodos.actualizarSocio(s);
                    JOptionPane.showMessageDialog(this, "Usuario Actualizado");
                } catch (SQLException ex) {
                    Logger.getLogger(editarSocio.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "ERROR EN ACTUALIZACION..!!");
                } catch (IOException ex) {
                    Logger.getLogger(editarSocio.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Valor de Consumo Incorrecto!");
            }
        }
    }//GEN-LAST:event_jButton_actualizarSocioActionPerformed

    public static boolean isNumero(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    private void jButton_eliminarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarSocioActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(modelo.getValueAt(TablaPersonas.getSelectedRow(), 1).toString());
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (resp == 0) {
            try {

                metodos.eliminarSocio(id);
                 JOptionPane.showMessageDialog(this, "Usuario Eliminado");
            } catch (SQLException ex) {
                Logger.getLogger(editarSocio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton_eliminarSocioActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void TablaPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPersonasMouseClicked
        // TODO add your handling code here:
        String strResultado = modelo.getValueAt(TablaPersonas.getSelectedRow(), 0).toString();
        ArrayList Resultados = new ArrayList();
        try {
            Resultados = metodos.verSocioN(strResultado);
            medidor.setText((Integer.toString((int) Resultados.get(1))));
            nombre.setText((String) Resultados.get(2));
            cedula.setText((String) Resultados.get(3));
            telefono.setText((String) Resultados.get(4));
            correo.setText((String) Resultados.get(5));
            consumoInicial.setText((Double.toString((double) Resultados.get(6))));
        } catch (SQLException ex) {
            Logger.getLogger(informacionSocios1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(informacionSocios1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TablaPersonasMouseClicked

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
                if (!Resultados.isEmpty()) {
                    llenarTabla(Resultados);
                } else {
                    JOptionPane.showMessageDialog(this, "Socio no Registrado");
                }
            } catch (SQLException | IOException ex) {
                Logger.getLogger(realizarCobros1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextField_codigoUsuario1ActionPerformed

    public void llenarTabla(ArrayList Resultados) {
        modelo = new DefaultTableModel();

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

    /* public void buscadorImagen() {
     JFileChooser chooser = new JFileChooser();
     //int returnVal = chooser.showOpenDialog(jButton_cargarSocio1);
     if (returnVal == JFileChooser.APPROVE_OPTION) {
     System.out.println("You chose to open this directory: "
     + chooser.getSelectedFile().getAbsolutePath());
     }
     File file = chooser.getSelectedFile();
     fullPath = file.getAbsolutePath();
     System.out.println(fullPath);
     ImageIcon fot = new ImageIcon(fullPath);
     Icon icono = new ImageIcon(fot.getImage().getScaledInstance(imagensocio.getWidth(), imagensocio.getHeight(), Image.SCALE_DEFAULT));
     //imagensocio.setIcon(icono);
     this.repaint();
     }
     */
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
    private javax.swing.JTable TablaPersonas;
    private javax.swing.JTextField cedula;
    private javax.swing.JTextField consumoInicial;
    private javax.swing.JTextField correo;
    private javax.swing.JButton jButton_actualizarSocio;
    private javax.swing.JButton jButton_buscarUsuario1;
    private javax.swing.JButton jButton_eliminarSocio;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_cedulaSocio;
    private javax.swing.JLabel jLabel_cedulaSocio1;
    private javax.swing.JLabel jLabel_correoSocio;
    private javax.swing.JLabel jLabel_correoSocio1;
    private javax.swing.JLabel jLabel_nombreSocio;
    private javax.swing.JLabel jLabel_nombreSocio1;
    private javax.swing.JLabel jLabel_nombreSocio2;
    private javax.swing.JLabel jLabel_telefonoSocio;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField_codigoUsuario1;
    private javax.swing.JTextField medidor;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
