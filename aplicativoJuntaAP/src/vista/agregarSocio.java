package vista;

import aplicativojuntaap.metodos;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import logica.manejador;
import logica.socio;
import java.text.SimpleDateFormat;
import java.util.Date;
import static vista.informacionSocios1.isNumeric;

public class agregarSocio extends javax.swing.JDialog {

    public String fullPath;

    public agregarSocio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        setTitle("Agregar Socio");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel_titulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton_guardarSocio = new javax.swing.JButton();
        jLabel_codigoSocio = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField_codigoSocio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel_codigoSocio1 = new javax.swing.JLabel();
        jTextField_nombresSocio1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_numMedidor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_cedulaSocio = new javax.swing.JTextField();
        jLabel_cedulaSocio1 = new javax.swing.JLabel();
        jLabel_cedulaSocio = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_telefonoSocio = new javax.swing.JTextField();
        jLabel_telefonoSocio = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        consumoInicial = new javax.swing.JTextField();
        jLabel_correoSocio1 = new javax.swing.JLabel();
        jLabel_correoSocio = new javax.swing.JLabel();
        jTextField_correoSocio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

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

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(703, 573));
        setMinimumSize(new java.awt.Dimension(703, 573));
        setPreferredSize(new java.awt.Dimension(710, 562));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Microsoft JhengHei", 1, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(28, 108, 171));
        jLabel_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_titulo.setText("Añadir Socio");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 660, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 660, 10));

        jButton_guardarSocio.setBackground(new java.awt.Color(0, 97, 155));
        jButton_guardarSocio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_guardarSocio.setForeground(new java.awt.Color(255, 255, 255));
        jButton_guardarSocio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        jButton_guardarSocio.setText("Guardar");
        jButton_guardarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardarSocioActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_guardarSocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, 140, 40));

        jLabel_codigoSocio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_codigoSocio.setText("Código");
        getContentPane().add(jLabel_codigoSocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 153, -1));

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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, 130, 40));

        jTextField_codigoSocio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_codigoSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_codigoSocioActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_codigoSocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 449, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 51));
        jLabel5.setText("*");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 20, 11));

        jLabel_codigoSocio1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_codigoSocio1.setText("Nombre");
        getContentPane().add(jLabel_codigoSocio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 116, -1));

        jTextField_nombresSocio1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_nombresSocio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombresSocio1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_nombresSocio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 449, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 51));
        jLabel3.setText("*");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 20, 10));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 51));
        jLabel4.setText("*");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 20, -1));

        jTextField_numMedidor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_numMedidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_numMedidorActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_numMedidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 449, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 51));
        jLabel7.setText("*");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 20, -1));

        jTextField_cedulaSocio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_cedulaSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_cedulaSocioActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_cedulaSocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 449, -1));

        jLabel_cedulaSocio1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_cedulaSocio1.setText("Num. Medidor");
        getContentPane().add(jLabel_cedulaSocio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, 27));

        jLabel_cedulaSocio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_cedulaSocio.setText("Cedula");
        getContentPane().add(jLabel_cedulaSocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 140, 27));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 51));
        jLabel6.setText("*");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 20, -1));

        jTextField_telefonoSocio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_telefonoSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_telefonoSocioActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_telefonoSocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 449, -1));

        jLabel_telefonoSocio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_telefonoSocio.setText("Teléfono");
        getContentPane().add(jLabel_telefonoSocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 130, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 51));
        jLabel8.setText("*");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 20, -1));

        consumoInicial.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        consumoInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consumoInicialActionPerformed(evt);
            }
        });
        getContentPane().add(consumoInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 449, -1));

        jLabel_correoSocio1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_correoSocio1.setText("Consumo Inicial");
        getContentPane().add(jLabel_correoSocio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, 28));

        jLabel_correoSocio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_correoSocio.setText("Correo electrónico");
        getContentPane().add(jLabel_correoSocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, 28));

        jTextField_correoSocio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_correoSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_correoSocioActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_correoSocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 449, -1));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 660, 450));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/texturas-pared-gris-fondo_74190-4389 (1).jpg"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_guardarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardarSocioActionPerformed
        int cont = 0;
        if (jTextField_cedulaSocio.getText().isEmpty()) {
            cont++;
            JOptionPane.showMessageDialog(this, "Debe Ingresar una cedula");
        }
        if (jTextField_codigoSocio.getText().isEmpty()) {
            cont++;
            JOptionPane.showMessageDialog(this, "Debe Ingresar codigo");
        }
        if (jTextField_nombresSocio1.getText().isEmpty()) {
            cont++;
            JOptionPane.showMessageDialog(this, "Debe Ingresar el Nombre");
        }
        if (jTextField_numMedidor.getText().isEmpty()) {
            cont++;
            JOptionPane.showMessageDialog(this, "Debe Ingresar un numero de Medidor");
        }
        if (jTextField_telefonoSocio.getText().isEmpty()) {
            cont++;
            JOptionPane.showMessageDialog(this, "Debe Ingresar un numero de telefono o celular");
        }
        if (consumoInicial.getText().isEmpty()) {
            cont++;
            JOptionPane.showMessageDialog(this, "Debe Ingresar el consumo inicial");
        }
        if (cont == 0) {
            manejador m = new manejador();
            socio s;
            metodos metodos = new metodos();
            ArrayList<Object> valores = new ArrayList<>();
            Date objDate = new Date(); // Sistema actual La fecha y la hora se asignan a objDate 
            
            //ANIO
            String strDateFormat = "yyyy"; // El formato de fecha está especificado  
            SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto 
            System.out.println(objSDF.format(objDate));
            String anio = objSDF.format(objDate);
            
            //MES
            strDateFormat = "MM"; // El formato de fecha está especificado  
            objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto 
            System.out.println(objSDF.format(objDate));
            String mes = objSDF.format(objDate);
            
            int mesEntero = Integer.parseInt(mes);
            if(mesEntero==1){
                mesEntero=12;
            }else{
                mesEntero=mesEntero-1;
            }
            
            //DIA
            strDateFormat = "dd"; // El formato de fecha está especificado  
            objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto 
            System.out.println(objSDF.format(objDate));
            String dia = objSDF.format(objDate);
            
            String fecha = anio+"-"+mesEntero+"-"+dia;
            
            System.out.println("FECHAAAAAA: " + fecha);
            int codi = Integer.parseInt(jTextField_codigoSocio.getText());
            int medidor = Integer.parseInt(jTextField_numMedidor.getText());
            double consumo = 0.0;
            if (isDouble(consumoInicial.getText())) {
                consumo = Double.parseDouble(consumoInicial.getText());
                System.out.println(codi);
                s = m.crearSocio(codi, medidor, jTextField_nombresSocio1.getText(), jTextField_cedulaSocio.getText(), jTextField_telefonoSocio.getText(), jTextField_correoSocio.getText(), consumo);
                valores.add(fecha);
                valores.add(codi);
                valores.add(consumo);
                try {
                    metodos.registrarSocio(s);
                    metodos.registrarConsumoI(valores);
                    JOptionPane.showMessageDialog(this, "Socio Agregado Correctamente");
                    jTextField_cedulaSocio.setText("");
                    jTextField_codigoSocio.setText("");
                    jTextField_nombresSocio1.setText("");
                    jTextField_cedulaSocio.setText("");
                    jTextField_numMedidor.setText("");
                    jTextField_telefonoSocio.setText("");
                    jTextField_correoSocio.setText("");
                    consumoInicial.setText("");
                } catch (SQLException | IOException ex) {
                    JOptionPane.showMessageDialog(this, "Datos erróneos", "Error!", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(agregarSocio.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Valor de Consumo incorrecto", "Error!", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_jButton_guardarSocioActionPerformed

    public static boolean isDouble(String cadena) {

        boolean resultado;

        try {
            Double.parseDouble(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    private void jTextField_numMedidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_numMedidorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_numMedidorActionPerformed

    private void jTextField_nombresSocio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombresSocio1ActionPerformed

    }//GEN-LAST:event_jTextField_nombresSocio1ActionPerformed

    private void jTextField_correoSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_correoSocioActionPerformed

    }//GEN-LAST:event_jTextField_correoSocioActionPerformed

    private void jTextField_telefonoSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_telefonoSocioActionPerformed

    }//GEN-LAST:event_jTextField_telefonoSocioActionPerformed

    private void jTextField_codigoSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_codigoSocioActionPerformed

    }//GEN-LAST:event_jTextField_codigoSocioActionPerformed

    private void jTextField_cedulaSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_cedulaSocioActionPerformed

    }//GEN-LAST:event_jTextField_cedulaSocioActionPerformed

    private void consumoInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumoInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consumoInicialActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        super.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void buscadorImagen() {
        JFileChooser chooser = new JFileChooser();

        /*int returnVal = chooser.showOpenDialog(jButton_cargarSocio);
         if (returnVal == JFileChooser.APPROVE_OPTION) {
         System.out.println("You chose to open this directory: "
         + chooser.getSelectedFile().getAbsolutePath());
         }*/
        File file = chooser.getSelectedFile();
        fullPath = file.getAbsolutePath();
        System.out.println(fullPath);
        ImageIcon fot = new ImageIcon(fullPath);

        this.repaint();
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
    private javax.swing.JTextField consumoInicial;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_guardarSocio;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_cedulaSocio;
    private javax.swing.JLabel jLabel_cedulaSocio1;
    private javax.swing.JLabel jLabel_codigoSocio;
    private javax.swing.JLabel jLabel_codigoSocio1;
    private javax.swing.JLabel jLabel_correoSocio;
    private javax.swing.JLabel jLabel_correoSocio1;
    private javax.swing.JLabel jLabel_telefonoSocio;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField_cedulaSocio;
    private javax.swing.JTextField jTextField_codigoSocio;
    private javax.swing.JTextField jTextField_correoSocio;
    private javax.swing.JTextField jTextField_nombresSocio1;
    private javax.swing.JTextField jTextField_numMedidor;
    private javax.swing.JTextField jTextField_telefonoSocio;
    // End of variables declaration//GEN-END:variables
}
