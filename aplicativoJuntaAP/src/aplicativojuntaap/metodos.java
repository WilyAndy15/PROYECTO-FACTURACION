/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicativojuntaap;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import logica.asistenciaReunion;
import logica.convocatoriaTrabajos;
import logica.reunion;
import logica.socio;
import logica.trabajo;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Kami Osita Bebe
 */
public class metodos {

    static Statement st = null;
    public Conectar cone = new Conectar();
    public Connection con = cone.getConexion();
    ResultSet rs = null;
    PreparedStatement pt = null;

    static double multaAtrasoReunion;
    static double multaFaltaReunion;
    static double multaFaltaTrabajo;
    static double cantidadMetrosBase;
    static double multaExceso;
    static double multaMeses;
    static int metrosBase;
    static double metrosBase2;
    String Usuario;
    String Password;
    int id;


    /*INSERT INTO*/
    public void crearReunion(reunion reunion) throws SQLException {
        String sql = "";
        sql = "INSERT INTO proyecto_agua.reunion (fecha, nombre, descripcion) VALUES ('" + reunion.getFecha() + "', '" + reunion.getNombre() + "', '" + reunion.getDescripcion() + "');";
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "REUNIÓN CREADA CON ÉXITO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR!... La reunion ya existe");
        }
    }

    public void crearAsistenciasReuniones(String fecha) throws SQLException {
        String sql = "";
        sql = "SELECT idsocio FROM proyecto_agua.socio;";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        ArrayList<Object> ids = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt(1);
            ids.add(id);
        }
        for (int i = 0; i < ids.size(); i++) {
            String sql1 = "";
            sql1 = "INSERT INTO proyecto_agua.socio_has_reunion (socio_idsocio, reunion_fecha, tipoAsis, pago) VALUES (" + ids.get(i) + ", '" + fecha + "', " + 0 + ", '0');";
            try {
                st = con.createStatement();
                st.executeUpdate(sql1);
            } catch (Exception e) {
            }
        }
    }

    public void crearRegistroAsistencia(int id, String fecha, int tAsis, int pago) throws SQLException {
        String sql = "";
        sql = "UPDATE proyecto_agua.socio_has_reunion SET tipoAsis = " + tAsis + " WHERE reunion_fecha = '" + fecha + "' and socio_idsocio = " + id + ";";
        try {
            pt = con.prepareStatement(sql);
            pt.executeUpdate();
            System.out.println("Ingreso CORECCTO de las asistencia");
            JOptionPane.showMessageDialog(null, "Ingreso CORRECTO de las asistencia");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }

        /*String sql = "UPDATE proyecto_agua.trabajo_has_socio SET asistencia = '" + asistencias + "' WHERE (trabajo_fecha = '" + fecha + "') and (socio_idsocio = '" + idsocio + "');";
         pt = con.
         pt.executeUpdate();*/
    }

    public void crearTrabajo(trabajo trabajo) throws SQLException {
        String sql = "";
        sql = "INSERT INTO proyecto_agua.trabajo (fecha, nombre, descripcion) VALUES ('" + trabajo.getFecha() + "', '" + trabajo.getNombre() + "', '" + trabajo.getDescripcion() + "');";
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Trabajo Registrado");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error, Vuelva a intentarlo");
        }
    }

    public void crearUsuarioConTrabajo(convocatoriaTrabajos convocatoriaTrabajo) throws SQLException {
        String sql = "";
        sql = "INSERT INTO proyecto_agua.trabajo_has_socio (trabajo_fecha, socio_idsocio, asistencia, pago) VALUES ('" + convocatoriaTrabajo.getTrabajo_fecha() + "', '" + convocatoriaTrabajo.getSocio_idsocio() + "', '" + convocatoriaTrabajo.getAsistencia() + "\','0\');";
        System.out.println(sql);
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Usuario Agregado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR!! .... Usuario ya registrado");
        }
    }

    public ArrayList obtenerPagos(int idSocio) {
        try {
            ArrayList<String> Pagos = new ArrayList<>();
            st = con.createStatement();
            rs = st.executeQuery("SELECT d.fecha, d.estado from proyecto_agua.pago d where d.idsocio=" + idSocio + ";");
            while (rs.next()) {
                Pagos.add(rs.getString(1));
                Pagos.add(rs.getString(2));
            }
            return Pagos;
        } catch (SQLException ex) {
            Logger.getLogger(metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void eliminarSocio(int id) throws SQLException {
        pt = con.prepareStatement("UPDATE proyecto_agua.socio SET estado = 1 WHERE (idsocio=" + id+ ")");
        pt.executeUpdate();
    }

    /*SELECT*/
    /*REUNION*/
    public ArrayList obtenerReuniones() throws SQLException {
        String sql = "SELECT fecha FROM proyecto_agua.reunion";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        ArrayList<String> fecha = new ArrayList<>();
        while (rs.next()) {
            String reunion = rs.getString(1);
            fecha.add(reunion);
        }
        return fecha;
    }

    public ArrayList<String> obtenerInformacionReunion(String fecha) throws SQLException {
        String sql = "";
        sql = "SELECT * FROM proyecto_agua.reunion WHERE fecha = '" + fecha + "'";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        ArrayList<String> informacion = new ArrayList<>();
        while (rs.next()) {
            String nombre = rs.getString(2);
            informacion.add(nombre);
            String descripcion = rs.getString(3);
            informacion.add(descripcion);
        }
        return informacion;
    }

    public ArrayList obtenerAsiste(String fecha) throws SQLException {
        String sql = "SELECT nombre FROM proyecto_agua.socio s, proyecto_agua.socio_has_reunion sr WHERE sr.tipoAsis=2 AND sr.reunion_fecha='" + fecha + "' AND s.idsocio=sr.socio_idsocio;";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        ArrayList<String> socios = new ArrayList<>();
        while (rs.next()) {
            String nombres = rs.getString(1);
            socios.add(nombres);
        }
        return socios;
    }

    public ArrayList obtenerAtraso(String fecha) throws SQLException {
        String sql = "SELECT nombre FROM proyecto_agua.socio s, proyecto_agua.socio_has_reunion sr WHERE sr.tipoAsis=1 AND sr.reunion_fecha='" + fecha + "' AND s.idsocio=sr.socio_idsocio;";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        ArrayList<String> socios = new ArrayList<>();
        while (rs.next()) {
            String nombres = rs.getString(1);
            socios.add(nombres);
        }
        return socios;
    }

    public ArrayList obtenerFalta(String fecha) throws SQLException {
        String sql = "SELECT nombre FROM proyecto_agua.socio s, proyecto_agua.socio_has_reunion sr WHERE sr.tipoAsis=0 AND sr.reunion_fecha='" + fecha + "' AND s.idsocio=sr.socio_idsocio;";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        ArrayList<String> socios = new ArrayList<>();
        while (rs.next()) {
            String nombres = rs.getString(1);
            socios.add(nombres);
        }
        return socios;
    }

    /*TRABAJO*/
    public ArrayList obtenerTrabajos() throws SQLException {
        String sql = "SELECT fecha FROM proyecto_agua.trabajo;";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        ArrayList<String> fecha = new ArrayList<>();
        while (rs.next()) {
            String reunion = rs.getString(1);
            fecha.add(reunion);
        }
        return fecha;
    }

    public ArrayList<String> obtenerInformacionTrabajo(String fecha) throws SQLException {
        String sql = "";
        sql = "SELECT * FROM proyecto_agua.trabajo WHERE fecha = '" + fecha + "'";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        ArrayList<String> informacion = new ArrayList<>();
        while (rs.next()) {
            String nombre = rs.getString(2);
            informacion.add(nombre);
            String descripcion = rs.getString(3);
            informacion.add(descripcion);
        }
        return informacion;
    }

    public ArrayList obtenerUsuariosConvocados(String fecha) throws SQLException {
        String sql = "SELECT st.socio_idsocio, s.nombre, st.asistencia FROM proyecto_agua.socio s, proyecto_agua.trabajo_has_socio st WHERE s.idsocio=st.socio_idsocio AND st.trabajo_fecha='" + fecha + "' ORDER BY st.socio_idsocio ASC;";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        ArrayList<String> socios = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt(1);
            socios.add("" + id);
            String nombres = rs.getString(2);
            socios.add(nombres);
            int estado = rs.getInt(3);
            if (estado == 0) {
                socios.add("Convocado - Falta");
            }else{
                socios.add("Convocado - Asiste");
            }

        }
        return socios;
    }

    /*USUSARIOS*/
    public ArrayList obtenerUnicoUsuario(String id) throws SQLException {
        String sql = "SELECT nombre FROM proyecto_agua.socio WHERE idsocio=" + id + " and estado = 0;";
        ArrayList<String> socios = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                String nombres = rs.getString(1);
                socios.add(nombres);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error, Vuelva a intentarlo");
        }
        return socios;
    }

    public ArrayList obtenerUsuarios(String nombre) throws SQLException {
        String sql = "SELECT nombre FROM proyecto_agua.socio where nombre Like '%" + nombre + "%' and estado = 0";
        ArrayList<String> socios = new ArrayList<>();

        st = con.createStatement();
        rs = st.executeQuery(sql);
        try {
            while (rs.next()) {
                String nombres = rs.getString(1);
                socios.add(nombres);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error, Vuelva a intentarlo");
        }

        return socios;
    }

    public String obtenerID(String nombre) throws SQLException {
        String sql = "SELECT idsocio FROM proyecto_agua.socio WHERE nombre=\"" + nombre + "\" and estado = 0;";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        String id = "";
        while (rs.next()) {
            id = rs.getString(1);
        }
        return id;
    }

    /*UPDATE*/
    public void actualizarUsuarioConvocado(String fecha, int idsocio, int asistencias) throws SQLException {
        String sql = "UPDATE proyecto_agua.trabajo_has_socio SET asistencia = '" + asistencias + "' WHERE (trabajo_fecha = '" + fecha + "') and (socio_idsocio = '" + idsocio + "');";
        pt = con.prepareStatement(sql);
        pt.executeUpdate();
    }

    public void comprobarUsuario(String usu, String pass) throws SQLException {

        con = cone.getConexion();
        st = con.createStatement();
        String sql = "";
        String u;
        sql = "Select * from administrador where nombre = '" + usu + "'";
        try {
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
        }

        while (rs.next()) {
            Usuario = rs.getString(2);
            Password = rs.getString(1);
            System.out.println(Usuario + " " + Password);
        }
    }

    public void registrarSocio(socio s) throws FileNotFoundException, SQLException, IOException {
        // con = cone.getConexion();
        String insert = "INSERT INTO proyecto_agua.socio(idsocio,medidor,nombre,cedula,telefono,correo, consumoInicial) values(?,?,?,?,?,?,?)";
        // try (FileInputStream is = new FileInputStream(s.getImagen())) {
        pt = con.prepareStatement(insert);
        pt.setInt(1, s.getCodigo());
        pt.setInt(2, s.getNumMedidor());
        pt.setString(3, s.getNombre());
        pt.setString(4, s.getCedula());
        pt.setString(5, s.getTelefono());
        pt.setString(6, s.getCorreo());
        pt.setDouble(7, s.getConsumoI());
        pt.execute();
        // }
        pt.close();
    }

    public void actualizarSocio(socio s) throws FileNotFoundException, SQLException, IOException {
        //con = cone.getConexion();
        int id = s.getCodigo();
        String actualizarSocio = "UPDATE socio SET nombre=?,medidor=?,cedula=?,telefono=?,correo=?, consumoInicial =? where socio.idsocio = " + id;
        pt = con.prepareStatement(actualizarSocio);
        pt.setString(1, s.getNombre());
        pt.setInt(2, s.getNumMedidor());
        pt.setString(3, s.getCedula());
        pt.setString(4, s.getTelefono());
        pt.setString(5, s.getCorreo());
        pt.setDouble(6, s.getConsumoI());
        pt.executeUpdate();

    }

    public ArrayList obtenerInformacionSocioCodigo(int codigo) throws SQLException, IOException {
        ArrayList<Object> socio = new ArrayList<>();
        pt = con.prepareStatement("select * from proyecto_agua.socio where idsocio Like '" + codigo + "%' and estado =0");
        rs = pt.executeQuery();
        while (rs.next()) {
            String nombres = rs.getString(2);
            String apellidos = rs.getString(3);
            String cedula = rs.getString(4);
            String telefono = rs.getString(5);
            socio.add(nombres);
            socio.add(apellidos);
            socio.add(cedula);
            socio.add(telefono);
            //  socio.add(icono);
        }
        return socio;
    }

    public ArrayList obtenerInformacionSocioCodigoConsumo(String nombre) throws SQLException, IOException {
        ArrayList<Object> socio = new ArrayList<>();
        pt = con.prepareStatement("select * from proyecto_agua.socio where nombre = '" + nombre + "' and estado = 0");
        rs = pt.executeQuery();
        while (rs.next()) {
            String codigo = rs.getString(1);
            String medidor = rs.getString(2);
            String nombres = rs.getString(3);
            String cedula = rs.getString(4);
            String telefono = rs.getString(5);
            socio.add(codigo);
            socio.add(medidor);
            socio.add(nombres);
            socio.add(cedula);
            socio.add(telefono);
        }

        return socio;
    }

    public ArrayList obtenerInformacionSocioNombre(String nombre) throws SQLException, IOException {
        ArrayList<Object> socio = new ArrayList<>();
        // SELECT nombre,medidor,cedula FROM proyecto_agua.socio WHERE nombre Like "wily%";
        String consulta = "select * from proyecto_agua.socio where nombre Like '%" + nombre + "'%";
        System.out.println(consulta);
        pt = con.prepareStatement("select * from proyecto_agua.socio where nombre Like '%" + nombre + "%' and estado = 0");

        rs = pt.executeQuery();
        while (rs.next()) {
            String cod = rs.getString(1);
            String nombres = rs.getString(3);
            socio.add(cod);
            socio.add(nombres);
        }
        return socio;
    }

    public ArrayList ObtenerUsuariosConvocados(String fecha) throws SQLException {
        String sql = "";
        sql = "SELECT s.nombre FROM proyecto_agua.socio s, proyecto_agua.trabajo_has_socio t WHERE t.trabajo_fecha = '" + fecha + "' and s.idsocio = t.socio_idsocio";
        ArrayList<String> informacion = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                String nombre = rs.getString(1);
                informacion.add(nombre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(metodos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return informacion;

    }

    public ArrayList verSocioC(int codigo) throws SQLException, IOException {
        ArrayList<Object> socio = new ArrayList<>();
        pt = con.prepareStatement("select * from proyecto_agua.socio where idsocio = " + codigo + " and estado = 0 ;");
        rs = pt.executeQuery();
        while (rs.next()) {
            int cod = rs.getInt(1);
            int NumMedidor = rs.getInt(2);
            String nombre = rs.getString(3);
            String cedula = rs.getString(4);
            String telefono = rs.getString(5);
            String correo = rs.getString(6);
            socio.add(cod);
            socio.add(NumMedidor);
            socio.add(nombre);
            socio.add(cedula);
            socio.add(telefono);
            socio.add(correo);
            //  socio.add(icono);
        }
        return socio;
    }

    public ArrayList verSocioN(String nom) throws SQLException, IOException {
        ArrayList<Object> socio = new ArrayList<>();
        pt = con.prepareStatement("select * from proyecto_agua.socio where nombre = '" + nom + "' and estado = 0 ;");
        rs = pt.executeQuery();
        while (rs.next()) {
            int cod = rs.getInt(1);
            int NumMedidor = rs.getInt(2);
            String nombre = rs.getString(3);
            String cedula = rs.getString(4);
            String telefono = rs.getString(5);
            String correo = rs.getString(6);
            double consumo = rs.getDouble(7);
            socio.add(cod);
            socio.add(NumMedidor);
            socio.add(nombre);
            socio.add(cedula);
            socio.add(telefono);
            socio.add(correo);
            socio.add(consumo);
            //  socio.add(icono);
        }
        return socio;
    }

    public ArrayList informacionSocioReunion(int codigo) throws SQLException {
        ArrayList<String> informacionSocioReunion = new ArrayList<>();
        pt = con.prepareStatement("SELECT nombre FROM proyecto_agua.socio WHERE socio.idsocio=" + codigo);
        ResultSet rs1 = pt.executeQuery();
        while (rs1.next()) {
            String nombreSocio = rs1.getString(1);
            informacionSocioReunion.add(nombreSocio);

        }
        PreparedStatement st1 = con.prepareStatement("SELECT r.fecha, r.nombre, sr.tipoAsis FROM proyecto_agua.socio_has_reunion sr, proyecto_agua.reunion r WHERE sr.socio_idsocio=" + codigo + " AND r.fecha=sr.reunion_fecha;");
        rs = st1.executeQuery();
        while (rs.next()) {
            String fecha = rs.getString(1);
            String nombre = rs.getString(2);
            int tipoAsis = rs.getInt(3);
            String Asis = "";
            switch (tipoAsis) {
                case 2:
                    Asis = "Asiste";
                    break;
                case 1:
                    Asis = "Atraso";
                    break;
                case 0:
                    Asis = "Falta";
                    break;
                default:
                    break;
            }
            informacionSocioReunion.add(fecha);
            informacionSocioReunion.add(nombre);
            informacionSocioReunion.add(Asis);
        }
        return informacionSocioReunion;
    }

    public ArrayList informacionSocioTrabajo(String id) throws SQLException {
        String sql = "SELECT t.fecha, t.nombre, st.asistencia FROM proyecto_agua.trabajo_has_socio st, proyecto_agua.trabajo t WHERE st.socio_idsocio=" + id + " AND t.fecha=st.trabajo_fecha;";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        ArrayList<String> socios = new ArrayList<>();
        while (rs.next()) {
            String fecha = rs.getString(1);
            socios.add(fecha);
            String nombre = rs.getString(2);
            socios.add(nombre);
            int estado = rs.getInt(3);
            if (estado == 0) {
                socios.add("Asistió");
            }
            if (estado == 1) {
                socios.add("Faltó");
            }

        }
        return socios;
    }

    public ArrayList informacionSocioConsumoAnterior(int mes, int anio) throws SQLException {
        //SELECT * FROM tabla WHERE MONTH(colfecha) = 10 AND YEAR(colfecha) = 2016
        int mesAnterior = 0;
        if (mes == 1) {
            mesAnterior = 12;
            anio = anio - 1;
        } else {
            mesAnterior = mes - 1;
        }
        String sql = "SELECT s.idsocio, s.medidor, s.nombre, c.cantidad FROM proyecto_agua.socio s, proyecto_agua.consumo c WHERE MONTH(c.fecha) = " + mesAnterior + " and YEAR(c.fecha) = " + anio + " and  s.idsocio = c.socio_idsocio and s.estado = 0;";
        st = con.createStatement();//and  s.idsocio = c.socio_idsocio
        rs = st.executeQuery(sql);
        ArrayList<String> SocioConsumo = new ArrayList<>();
        while (rs.next()) {
            String idSocio = rs.getString(1);

            SocioConsumo.add(idSocio);
            String medidor = rs.getString(2);
            SocioConsumo.add(medidor);

            String nombre = rs.getString(3);
            SocioConsumo.add(nombre);
            String consumo = rs.getString(4);
            SocioConsumo.add(consumo);

        }
        return SocioConsumo;
    }

    public ArrayList informacionSocioConsumoActual(int mes, int anio) throws SQLException {
        String sql = "SELECT c.cantidad FROM proyecto_agua.socio s, proyecto_agua.consumo c WHERE MONTH(c.fecha) = " + mes + " and YEAR(c.fecha) = " + anio + " and  s.idsocio = c.socio_idsocio;";
        st = con.createStatement();//and  s.idsocio = c.socio_idsocio
        rs = st.executeQuery(sql);
        ArrayList<Object> ConsumoA = new ArrayList<>();
        while (rs.next()) {
            double idSocio = rs.getDouble(1);
            ConsumoA.add(idSocio);
        }
        return ConsumoA;
    }

    public ArrayList obtenerInformacionSocioCod(String codi) throws SQLException, IOException {
        ArrayList<Object> socio = new ArrayList<>();
        // SELECT nombre,medidor,cedula FROM proyecto_agua.socio WHERE nombre Like "wily%";
        pt = con.prepareStatement("select * from proyecto_agua.socio where idsocio = " + codi + " and estado = 0;");
        rs = pt.executeQuery();
        while (rs.next()) {
            String cod = rs.getString(1);
            String nombres = rs.getString(3);
            socio.add(cod);
            socio.add(nombres);
        }
        return socio;
    }

    public double obtenerMultasTrabajos(int codigo, String fecha) throws SQLException {
        //0 asiste
        //1 multa
        double calculo = 0.0;
        ArrayList<String> Multas = new ArrayList<>();
        st = con.createStatement();
        System.out.println("SELECT asistencia FROM proyecto_agua.trabajo_has_socio where trabajo_fecha <= " + fecha + " and pago=0 and socio_idsocio=" + codigo);
        rs = st.executeQuery("SELECT asistencia FROM proyecto_agua.trabajo_has_socio where trabajo_fecha <= '" + fecha + "' and pago=0 and socio_idsocio=" + codigo);
        while (rs.next()) {
            String tipoAsis = rs.getString(1);
            Multas.add(tipoAsis);
        }
        for (int i = 0; i < Multas.size(); i++) {
            if (Multas.get(i).equals("0")) {
                calculo = calculo + multaFaltaTrabajo;
            } else {
                calculo = calculo + 0;
            }
        }
        return calculo;
    }

    public void eliminarConvocado(String fecha, int id) throws SQLException{
          pt = con.prepareStatement("DELETE FROM proyecto_agua.trabajo_has_socio WHERE trabajo_fecha = '" +fecha +"' and socio_idsocio ="+id+";");
        try {
            pt.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(metodos.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
    }
    public double obtenerMultasReuniones(int codigo, String fecha) throws SQLException {
        //0 falta
        //1 atraso
        ArrayList<String> Multas = new ArrayList<>();
        st = con.createStatement();
        System.out.println("SELECT tipoAsis FROM proyecto_agua.socio_has_reunion where reunion_fecha <= " + fecha + " and pago=0 and socio_idsocio=" + codigo);
        rs = st.executeQuery("SELECT tipoAsis FROM proyecto_agua.socio_has_reunion where reunion_fecha <= '" + fecha + "' and pago=0 and socio_idsocio=" + codigo);
        while (rs.next()) {
            String tipoAsis = rs.getString(1);
            Multas.add(tipoAsis);
        }
        double calculo = 0.0;
        for (int i = 0; i < Multas.size(); i++) {
            if (Multas.get(i).equals("0")) {
                calculo = calculo + multaFaltaReunion;
            } else if (Multas.get(i).equals("2")) {
                calculo = calculo + 0;
            } else {
                calculo = calculo + multaAtrasoReunion;
            }
        }
        return calculo;
    }

    public void actualizarMultasReunion(String Fecha, int idSocio) throws SQLException {
        pt = con.prepareStatement("UPDATE proyecto_agua.socio_has_reunion SET pago = 1 WHERE (socio_idsocio=" + idSocio + ") and (reunion_fecha <= '" + Fecha + "')");
        pt.executeUpdate();
    }

    public void actualizarMultasTrabajo(String Fecha, int idSocio) throws SQLException {
        pt = con.prepareStatement("UPDATE proyecto_agua.trabajo_has_socio SET pago = 1 WHERE (socio_idsocio=" + idSocio + ") and (trabajo_fecha <= '" + Fecha + "')");
        pt.executeUpdate();
    }

    public void registrarConsumo(ArrayList datos) throws SQLException {
        String sql = "";
        String fecha = (String) datos.get(0);
        System.out.println(fecha);
        for (int i = 1; i < datos.size(); i = i + 3) {
            int cod = Integer.parseInt((String) datos.get(i));
            double cant = 0;
            if ((String) datos.get(i + 2) == null) {
                cant = 0;
            } else {
                cant = Double.parseDouble((String) datos.get(i + 2));
            }
            System.out.println(cod);
            System.out.println(cant);
            sql = "insert INTO proyecto_agua.consumo (fecha, socio_idsocio, cantidad) VALUES ('" + fecha + "', " + cod + "," + cant + " );";
           
                st = con.createStatement();
                st.executeUpdate(sql);

        
        }
    }

    public void registrarConsumoI(ArrayList datos) {
        String sql = "";
        String fecha = (String) datos.get(0);
        System.out.println(fecha);
        for (int i = 1; i < datos.size(); i = i + 2) {
            int cod = (int) datos.get(i);
            double cant = (double) datos.get(i + 1);
            sql = "insert INTO proyecto_agua.consumo (fecha, socio_idsocio, cantidad) VALUES ('" + fecha + "', " + cod + "," + cant + " );";
            try {
                st = con.createStatement();
                st.executeUpdate(sql);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void modificarConsumo(ArrayList datos) throws SQLException {
        String sql = "";
        String fecha = (String) datos.get(0);
        System.out.println(fecha);
        for (int i = 1; i < datos.size(); i = i + 3) {
            int cod = Integer.parseInt((String) datos.get(i));
            double cant = 0;
            if ((String) datos.get(i + 2) == null) {
                cant = 0;
            } else {
                cant = Double.parseDouble((String) datos.get(i + 2));
            }
            System.out.println(cod);
            System.out.println(cant);
            pt = con.prepareStatement("UPDATE proyecto_agua.consumo SET cantidad = " + cant + " where fecha =  ('" + fecha + "') and socio_idsocio = (" + cod + " );");
            pt.executeUpdate();
        }

    }

    public ArrayList obtenerPagoConsumo(int id, int mes, int anio) throws SQLException {
        ArrayList<Object> datos = new ArrayList<>();
        int mesAnterior = mes - 1;
        int anioAnterior = anio;
        String cactual = "0", canterior = "0";
        double totalSoloConsumo = 0.0;
        double excesoConsumo = 0.0;
        double totalConsumo = 0.0;
        if (mes == 1) {
            mesAnterior = 12;
            anioAnterior = anio - 1;

        }
        st = con.createStatement();
        rs = st.executeQuery("SELECT cantidad FROM proyecto_agua.consumo where MONTH(fecha) = " + mesAnterior + " and YEAR(fecha) = " + anioAnterior + " and   consumo.socio_idsocio = " + id + ";");
        while (rs.next()) {
            canterior = rs.getString(1);
            datos.add(canterior);

        }
        st = con.createStatement();
        rs = st.executeQuery("SELECT cantidad FROM proyecto_agua.consumo WHERE MONTH(fecha) = " + mes + " and YEAR(fecha) = " + anio + " and  consumo.socio_idsocio = " + id + ";");
        while (rs.next()) {
            cactual = rs.getString(1);
            datos.add(cactual);

        }
        for (int i = 0; i < datos.size(); i++) {
            System.out.println(datos.get(i));
        }

        double difConsumo = Double.parseDouble(cactual) - Double.parseDouble(canterior);
        datos.add(difConsumo);
        if (difConsumo <= metrosBase) {
            totalSoloConsumo = cantidadMetrosBase;

        } else {
            totalSoloConsumo = cantidadMetrosBase;
            for (int i = metrosBase; i < difConsumo; i++) {
                excesoConsumo += multaExceso;
                excesoConsumo = Math.round(excesoConsumo * 100)/100d;
            }

        }
        datos.add(totalSoloConsumo);
        datos.add(excesoConsumo);
        totalConsumo = totalSoloConsumo + excesoConsumo;
        datos.add(totalConsumo);
        return datos;

    }

    public void registrarPagos(ArrayList Pagos) {
        String sql = "";
        String fecha = (String) Pagos.get(0);
        System.out.println(fecha);
        for (int i = 1; i < Pagos.size(); i = i + 3) {
            int cod = Integer.parseInt((String) Pagos.get(i));
            double cant = 0;
            cant = (double) Pagos.get(i + 1);
            System.out.println(cod);
            System.out.println(cant);
            sql = "insert INTO proyecto_agua.pago (idsocio, estado, fecha, cantidadConsumo) VALUES ('" + cod + "', " + 0 + ",'" + fecha + "', " + cant + " );";
            try {
                st = con.createStatement();
                st.executeUpdate(sql);

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public void modificar_registrarPagos(ArrayList Pagos) throws SQLException {
        String sql = "";
        String fecha = (String) Pagos.get(0);
        System.out.println(fecha);
        for (int i = 1; i < Pagos.size(); i = i + 3) {
            int cod = Integer.parseInt((String) Pagos.get(i));
            double cant = 0;
            cant = (Double) Pagos.get(i + 1);
            System.out.println(cod);
            System.out.println(cant);
            pt = con.prepareStatement("update proyecto_agua.pago set cantidadConsumo = " + cant + " where fecha =  ('" + fecha + "') and idSocio = (" + cod + " );");
            pt.executeUpdate();
        }

    }

    public void actualizarPagos(String Fecha, int idSocio) throws SQLException {
        pt = con.prepareStatement("UPDATE proyecto_agua.pago SET estado = 1 WHERE (idsocio=" + idSocio + ") and (fecha <= '" + Fecha + "')");
        pt.executeUpdate();

    }

    public ArrayList multaMeses(String fecha, int id) throws SQLException {
        ArrayList<Object> cantidad = new ArrayList<>();
        ArrayList<Object> datosmultaMeses = new ArrayList<>();
        st = con.createStatement();
        //System.out.println("SELECT tipoAsis FROM proyecto_agua.socio_has_reunion where reunion_fecha <= " + fecha + " and pago=0 and socio_idsocio=" + codigo);
        rs = st.executeQuery("SELECT cantidadConsumo FROM proyecto_agua.pago where fecha < '" + fecha + "' and estado = 0 and idSocio=" + id + ";");
        while (rs.next()) {
            double cantidadConsumida = Double.parseDouble(rs.getString(1));
            cantidad.add(cantidadConsumida);
        }
        double calculo = 0.0;
        double mesesNopagados = 0.0;
        double excesoConsumo = 0.0;
        System.out.println("CANTIDAD DE MESES ADEUDADOS " + cantidad.size());
        for (int i = 0; i < cantidad.size(); i++) {
            calculo = calculo + multaMeses;
            if ((Double) cantidad.get(i) <= metrosBase) {
                mesesNopagados += cantidadMetrosBase;

            } else {
                mesesNopagados += cantidadMetrosBase;
                double c = (Double) cantidad.get(i) - metrosBase;
                for (int j = 0; j < (int) c; j++) {
                    excesoConsumo += multaExceso;

                }

            }

        }
        double meses_adeudados = cantidad.size();
        double total_mesesBase_recargo = mesesNopagados + excesoConsumo;
        datosmultaMeses.add(meses_adeudados);
        datosmultaMeses.add(calculo);
        datosmultaMeses.add(total_mesesBase_recargo);
        return datosmultaMeses;

    }

    public void recuperarPrecios(double noAsistiraReunion, double atrasoaReunion, double noAsistiraMinga, double consumoExceso, double mesesExceso, double cantidadMetros, double precioMetrosBase) {
        multaFaltaReunion = noAsistiraReunion;
        multaAtrasoReunion = atrasoaReunion;
        multaFaltaTrabajo = noAsistiraMinga;
        multaExceso = consumoExceso;
        multaMeses = mesesExceso;
        metrosBase = (int) cantidadMetros;
        cantidadMetrosBase = precioMetrosBase;
        metrosBase2 = cantidadMetros;
        System.out.println(multaFaltaReunion + "," + multaAtrasoReunion + "," + multaFaltaTrabajo + "," + multaExceso + "," + multaMeses + "," + metrosBase + "," + cantidadMetrosBase);
    }

    public void recuperarPreciosBaseDatos() {
        try {
            Double noAsistiraReunion = 0.0, atrasoaReunion = 0.0, noAsistiraMinga = 0.0, consumoExceso = 0.0, mesesExceso = 0.0, cantidadMetros = 0.0, precioMetrosBase = 0.0;
            st = con.createStatement();
            //System.out.println("SELECT tipoAsis FROM proyecto_agua.socio_has_reunion where reunion_fecha <= " + fecha + " and pago=0 and socio_idsocio=" + codigo);
            rs = st.executeQuery("SELECT idPrecios, cantidad FROM proyecto_agua.precios");
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                Double cantidad = Double.parseDouble(rs.getString(2));
                if (id == 1) {
                    noAsistiraReunion = cantidad;
                } else if (id == 2) {
                    atrasoaReunion = cantidad;
                } else if (id == 3) {
                    noAsistiraMinga = cantidad;
                } else if (id == 4) {
                    consumoExceso = cantidad;
                } else if (id == 5) {
                    mesesExceso = cantidad;
                } else if (id == 6) {
                    cantidadMetros = cantidad;
                } else {
                    precioMetrosBase = cantidad;
                }
            }
            recuperarPrecios(noAsistiraReunion, atrasoaReunion, noAsistiraMinga, consumoExceso, mesesExceso, cantidadMetros, precioMetrosBase);
        } catch (SQLException ex) {
            Logger.getLogger(metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //PRECIOS
    public void registrarPrecios(double noAsistiraReunion, double atrasoaReunion, double noAsistiraMinga, double consumoExceso, double mesesExceso, double cantidadMetros, double precioMetrosBase) {
        try {
            pt = con.prepareStatement("UPDATE proyecto_agua.precios SET cantidad= " + noAsistiraReunion + " where idPrecios=1");
            pt.executeUpdate();
            pt = con.prepareStatement("UPDATE proyecto_agua.precios SET cantidad= " + atrasoaReunion + " where idPrecios=2");
            pt.executeUpdate();
            pt = con.prepareStatement("UPDATE proyecto_agua.precios SET cantidad= " + noAsistiraMinga + " where idPrecios=3");
            pt.executeUpdate();
            pt = con.prepareStatement("UPDATE proyecto_agua.precios SET cantidad= " + consumoExceso + " where idPrecios=4");
            pt.executeUpdate();
            pt = con.prepareStatement("UPDATE proyecto_agua.precios SET cantidad= " + mesesExceso + " where idPrecios=5");
            pt.executeUpdate();
            pt = con.prepareStatement("UPDATE proyecto_agua.precios SET cantidad= " + cantidadMetros + " where idPrecios=6");
            pt.executeUpdate();
            pt = con.prepareStatement("UPDATE proyecto_agua.precios SET cantidad= " + precioMetrosBase + " where idPrecios=7");
            pt.executeUpdate();
            recuperarPrecios(noAsistiraReunion, atrasoaReunion, noAsistiraMinga, consumoExceso, mesesExceso, cantidadMetros, precioMetrosBase);
        } catch (SQLException e) {
            System.out.println("error");
        }
    }
    
    public ArrayList obtenerPreciosM() throws SQLException{
             ArrayList<Double> precios = new ArrayList<>();          
            st = con.createStatement();
            rs = st.executeQuery("Select cantidad from precios ");
            while (rs.next()) {
               double valor = rs.getDouble(1);
                System.out.println(valor);
               precios.add(valor);
            }
        
        return precios;
        
    }
    
    // administrador

    public void agregarAdministrador(String contrasenia, String usuario) {
        try {
            pt = con.prepareStatement("INSERT INTO ADMINISTRADOR (idAdministrador,nombre) VALUES ('" + contrasenia + "','" + usuario + "')");
            pt.execute();
            pt.close();
            JOptionPane.showMessageDialog(null, "Administrador Resgistrado Correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Al Registrar el Administrador");
        }
    }

    public int comprobarAdministrador(String contrasenia, String usuario) {
        try {
            int verificado = 0;
            System.out.println("Select nombre from ADMINISTRADOR where idAdministrador='" + contrasenia + "' and nombre='" + usuario + "')");
            st = con.createStatement();
            rs = st.executeQuery("Select nombre from ADMINISTRADOR where idAdministrador='" + contrasenia + "' and nombre='" + usuario + "'");
            while (rs.next()) {
                verificado++;
            }
            if (verificado == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("error");
            return 0;
        }
    }

    //FACTURA
    public void guardarFactura(int cod, String fecha, int tipo, double cantConsumo, double multaTrabajo, double multaReunion, double valorConsumo, double excesoConsumo, double totalMes, double mesesDebe, double valorMesesDebe, double recargos, double mReinstalacion, double total) throws SQLException {
        String insert = "INSERT INTO proyecto_agua.factura (idsocio,fecha,tipo,cantidadConsumo,multaTrabajo,multaReunion,valorConsumo, excesoConsumo, totalMes, mesesQueDebe, valorQueDebe, reinstalacion, Recargos, Total) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        // try (FileInputStream is = new FileInputStream(s.getImagen())) {
        pt = con.prepareStatement(insert);
        pt.setInt(1, cod);
        pt.setString(2, fecha);
        pt.setInt(3, tipo);
        pt.setDouble(4, cantConsumo);
        pt.setDouble(5, multaTrabajo);
        pt.setDouble(6, multaReunion);
        pt.setDouble(7, valorConsumo);
        pt.setDouble(8, excesoConsumo);
        pt.setDouble(9, totalMes);
        pt.setDouble(10, mesesDebe);
        pt.setDouble(11, valorMesesDebe);
        pt.setDouble(12, recargos);
        pt.setDouble(13, mReinstalacion);
        pt.setDouble(14, total);
        pt.execute();
        // }
        pt.close();

    }

    public void crearReporteUsuario(int cod, File ruta) {
        int cont = 6;
        try {
            st = con.createStatement();
            rs = st.executeQuery("Select s.idsocio, s.nombre, s.medidor, f.fecha, f.cantidadConsumo, f.valorConsumo, f.excesoConsumo, f.totalMes, f.mesesQueDebe, f.valorQueDebe, f.recargos, f.multaTrabajo, f.multaReunion, f.reinstalacion, f.Total from proyecto_agua.factura f, proyecto_agua.socio s where s.idsocio =" + cod + " and f.idsocio=" + cod + ";");
            Workbook book = new XSSFWorkbook();
            org.apache.poi.ss.usermodel.Sheet sheet = book.createSheet("Reporte");
            
            Row row1 = sheet.createRow(2);
            row1.createCell(0).setCellValue("CODIGO:");
            row1.createCell(2).setCellValue("NOMBRE:");
            row1.createCell(4).setCellValue("NUM. MEDIDOR:");

            Row row = sheet.createRow(5);

            row.createCell(0).setCellValue("FECHA PAGO");
            row.createCell(1).setCellValue("CONSUMO");
            row.createCell(2).setCellValue("VALOR CONSUMO");
            row.createCell(3).setCellValue("EXC. CONSUMO");
            row.createCell(4).setCellValue("TOTAL DEL MES");
            row.createCell(5).setCellValue("MESES QUE DEBE");
            row.createCell(6).setCellValue("VALOR QUE DEBE");
            row.createCell(7).setCellValue("RECARGOS");
            row.createCell(8).setCellValue("MULTA TRABAJOS");
            row.createCell(9).setCellValue("MULTA REUNIONES");
            row.createCell(10).setCellValue("MULTA REINSTALACION");
            row.createCell(11).setCellValue("TOTAL");

            while (rs.next()) {
                row1.createCell(1).setCellValue(rs.getInt(1));
                row1.createCell(3).setCellValue(rs.getString(2));
                row1.createCell(5).setCellValue(rs.getInt(3));
                row = sheet.createRow(cont);
                row.createCell(0).setCellValue(rs.getString(4));
                row.createCell(1).setCellValue(rs.getDouble(5));
                row.createCell(2).setCellValue(rs.getDouble(6));
                row.createCell(3).setCellValue(rs.getDouble(7));
                row.createCell(4).setCellValue(rs.getDouble(8));
                row.createCell(5).setCellValue(rs.getDouble(9));
                row.createCell(6).setCellValue(rs.getDouble(10));
                row.createCell(7).setCellValue(rs.getDouble(11));
                row.createCell(8).setCellValue(rs.getDouble(12));
                row.createCell(9).setCellValue(rs.getDouble(13));
                row.createCell(10).setCellValue(rs.getDouble(14));
                row.createCell(11).setCellValue(rs.getDouble(15));
                cont++;

            }
            for (int i = 0; i < 15; i++) {
                sheet.autoSizeColumn(i);
            }

            try {
                FileOutputStream fileout = new FileOutputStream(ruta + "Usuario_" + cod + ".xlsx");
                book.write(fileout);
                fileout.close();
            } catch (Exception e) {
            }
        } catch (SQLException ex) {
            Logger.getLogger(metodos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void crearExcel(int mes, int anio, File ruta) throws SQLException {

        int cont = 4;
        st = con.createStatement();
        rs = st.executeQuery("Select s.idsocio,s.cedula, s.nombre, s.medidor, f.cantidadConsumo, f.valorConsumo, f.excesoConsumo, f.totalMes, f.mesesQueDebe, f.valorQueDebe, f.recargos, f.multaTrabajo, f.multaReunion, f.reinstalacion, f.Total from proyecto_agua.factura f, proyecto_agua.socio s where MONTH(f.fecha) = " + mes + " and YEAR(f.fecha) = " + anio + " and s.idsocio = f.idsocio;");
        Workbook book = new XSSFWorkbook();
        org.apache.poi.ss.usermodel.Sheet sheet = book.createSheet("Reporte");

        Row row = sheet.createRow(3);
        row.createCell(0).setCellValue("CODIGO");
        row.createCell(1).setCellValue("CEDULA");
        row.createCell(2).setCellValue("NOMBRE");
        row.createCell(3).setCellValue("NUM. MEDIDOR");
        row.createCell(4).setCellValue("CONSUMO");
        row.createCell(5).setCellValue("VALOR CONSUMO");
        row.createCell(6).setCellValue("EXC. CONSUMO");
        row.createCell(7).setCellValue("TOTAL DEL MES");
        row.createCell(8).setCellValue("MESES QUE DEBE");
        row.createCell(9).setCellValue("VALOR QUE DEBE");
        row.createCell(10).setCellValue("RECARGOS");
        row.createCell(11).setCellValue("MULTA TRABAJOS");
        row.createCell(12).setCellValue("MULTA REUNIONES");
        row.createCell(13).setCellValue("MULTA REINSTALACION");
        row.createCell(14).setCellValue("TOTAL");

        while (rs.next()) {
            row = sheet.createRow(cont);
            row.createCell(0).setCellValue(rs.getInt(1));
            row.createCell(1).setCellValue(rs.getString(2));
            row.createCell(2).setCellValue(rs.getString(3));
            row.createCell(3).setCellValue(rs.getInt(4));
            row.createCell(4).setCellValue(rs.getDouble(5));
            row.createCell(5).setCellValue(rs.getDouble(6));
            row.createCell(6).setCellValue(rs.getDouble(7));
            row.createCell(7).setCellValue(rs.getDouble(8));
            row.createCell(8).setCellValue(rs.getDouble(9));
            row.createCell(9).setCellValue(rs.getDouble(10));
            row.createCell(10).setCellValue(rs.getDouble(11));
            row.createCell(11).setCellValue(rs.getDouble(12));
            row.createCell(12).setCellValue(rs.getDouble(13));
            row.createCell(13).setCellValue(rs.getDouble(14));
            row.createCell(14).setCellValue(rs.getDouble(15));
            cont++;

        }
        for (int i = 0; i < 15; i++) {
            sheet.autoSizeColumn(i);
        }

        try {

            FileOutputStream fileout = new FileOutputStream(ruta + "_" + mes + "_" + anio + ".xlsx");
            book.write(fileout);
            fileout.close();
        } catch (Exception e) {
        }
    }

    public void insertarReinstalacion(int id, double valor, String fecha) throws SQLException {
        String sql = "insert INTO proyecto_agua.reinstalacion (idsocio, valor,estado, fecha) VALUES (" + id + ", " + valor + "," + 0 + ",'" + fecha + "');";
        try {
            st = con.createStatement();
            st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error valor incorrecto");
        }

    }

    public void modificarReinstalacion(int id, double valor, String fecha) throws SQLException {
        pt = con.prepareStatement("UPDATE proyecto_agua.reinstalacion SET valor= " + valor + " where idsocio=" + id + " and fecha = '" + fecha + "';");
        pt.executeUpdate();

    }

    public Double Reinstalacion(int id) throws SQLException {
        st = con.createStatement();
        rs = st.executeQuery("Select valor from proyecto_agua.reinstalacion where idsocio = " + id + " and estado = 0;");
        ArrayList<Double> reinstalaciones = new ArrayList();
        reinstalaciones.add(0.0);
        while (rs.next()) {
            reinstalaciones.add(rs.getDouble(1));
        }
        double valor = 0;
        for (int i = 0; i < reinstalaciones.size(); i++) {
            valor = valor + reinstalaciones.get(i);
        }
        return valor;
    }

    public void imprimirFactura(ArrayList factura) throws FileNotFoundException, DocumentException {
        // Creating a PdfWriter       
       
            String dest = "C:\\Users\\William Sanchez\\OneDrive\\Documents\\Facturas\\factura.pdf";
        // Creating a PdfDocument       
        Font f = new Font();
        f.setSize(8);
        Document document = new Document(PageSize.A4, 15, 15, 15, 15);
        PdfWriter.getInstance(document, new FileOutputStream(new File(dest)));
        document.open();
        //CABECERA
        Paragraph paragraph1 = new Paragraph(10);
        paragraph1.setFont(f);
        paragraph1.add((String) factura.get(0) + (String) factura.get(1) + "\n");

        document.add(paragraph1);

        paragraph1 = new Paragraph(10);
        paragraph1.setFont(f);
        paragraph1.add((String) factura.get(2) + (String) factura.get(3) + "\n");
        paragraph1.add((String) factura.get(4) + (String) factura.get(5) + "\n");
        document.add(paragraph1);

        paragraph1 = new Paragraph(10);
        paragraph1.setFont(f);
        paragraph1.add((String) factura.get(6) + (String) factura.get(7) + "\n");
        paragraph1.add("==================================\n");
        document.add(paragraph1);
        //CUERPO FACTURA
        paragraph1 = new Paragraph(10);
        paragraph1.setFont(f);
        paragraph1.add((String) factura.get(8) + ": " + (String) factura.get(14) + "\n");
        paragraph1.add((String) factura.get(9) + ": " + (String) factura.get(15) + "\n");
        paragraph1.add((String) factura.get(10) + ": ");
        paragraph1.add((String) factura.get(16) + "\n");
        paragraph1.add((String) factura.get(11) + ": ");
        paragraph1.add(Chunk.TABBING);
        paragraph1.add((String) factura.get(17) + "\n");
        paragraph1.add((String) factura.get(12) + ": ");
        paragraph1.add(Chunk.TABBING);
        paragraph1.add((String) factura.get(18) + "\n");

        paragraph1.add("==================================\n");
        paragraph1.add((String) factura.get(20));
        paragraph1.add(Chunk.TABBING);
        paragraph1.add(Chunk.TABBING);
        paragraph1.add(Chunk.TABBING);
        paragraph1.add((String) factura.get(21) + "\n");

        paragraph1.add((String) factura.get(22));
        paragraph1.add(Chunk.TABBING);
        paragraph1.add(Chunk.TABBING);
        paragraph1.add((String) factura.get(23) + "\n");

        paragraph1.add((String) factura.get(24));
        paragraph1.add(Chunk.TABBING);
        paragraph1.add(Chunk.TABBING);
        paragraph1.add((String) factura.get(25) + "\n");

        paragraph1.add((String) factura.get(26));
        paragraph1.add(Chunk.TABBING);
        paragraph1.add(Chunk.TABBING);
        paragraph1.add((String) factura.get(27) + "\n");

        paragraph1.add((String) factura.get(28));
        paragraph1.add(Chunk.TABBING);
        paragraph1.add(Chunk.TABBING);

        paragraph1.add((String) factura.get(29) + "\n");
        paragraph1.add((String) factura.get(30));
        paragraph1.add(Chunk.TABBING);
        paragraph1.add(Chunk.TABBING);
        paragraph1.add((String) factura.get(31) + "\n");
        paragraph1.add((String) factura.get(36));
        paragraph1.add(Chunk.TABBING);
        paragraph1.add(Chunk.TABBING);
        paragraph1.add((String) factura.get(37) + "\n");
        paragraph1.add((String) factura.get(39));
        paragraph1.add(Chunk.TABBING);
        paragraph1.add((String) factura.get(40) + "\n");
        paragraph1.add("==================================\n");
        ////////////////////////////
        paragraph1.add((String) factura.get(32));
        paragraph1.add(Chunk.TABBING);
        paragraph1.add((String) factura.get(38) + "\n");
        ////////////////////////////
        paragraph1.add((String) factura.get(33));
        paragraph1.add(Chunk.TABBING);
        paragraph1.add("0.0" + "\n");
        ////////////////////////////
        paragraph1.add((String) factura.get(34));
        paragraph1.add(Chunk.TABBING);
        paragraph1.add(Chunk.TABBING);
        paragraph1.add("0.0" + "\n");
        ////////////////////////////
        paragraph1.add((String) factura.get(35));
        paragraph1.add(Chunk.TABBING);
        paragraph1.add(Chunk.TABBING);
        paragraph1.add((String) factura.get(38));
        paragraph1.add("\n");
        paragraph1.add("\n");
        paragraph1.add("\n");
        paragraph1.add("_"+"\n");
        document.add(paragraph1);
        document.close();

        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
        java.io.File fichero = new java.io.File("C:\\Users\\William Sanchez\\OneDrive\\Documents\\Facturas\\factura.pdf");
        if (desktop.isSupported(Desktop.Action.PRINT)) {
            try {
                    desktop.print(fichero);
            } catch (Exception e) {
                System.out.print("El sistema no permite imprimir usando la clase Desktop");
                e.printStackTrace();
            }
        } else {
            System.out.print("El sistema no permite imprimir usando la clase Desktop");
        }
        
        
        

    }
    
    public void pagarReinstalacion(int id, String fecha) throws SQLException{
        pt = con.prepareStatement("UPDATE proyecto_agua.reinstalacion SET estado= " + 1 + " where idsocio=" + id + " and fecha <= '" + fecha + "';");
        pt.executeUpdate();
    }

    /* public void imprimirFactura1(ArrayList factura) throws FileNotFoundException, DocumentException {
     // Creating a PdfWriter       
     String dest = "C:\\Users\\WilyAndy\\Documents\\ProyectoAP\\factura.pdf";
     // Creating a PdfDocument       
     PdfDocument pdf = new PdfDocument();
     // Creating a Document        
     Document document = new Document();
     PdfWriter.getInstance(document, new FileOutputStream(new File(dest)));
     document.open();
     //CABECERA
     Paragraph paragraph1 = new Paragraph();
     paragraph1.add((String) factura.get(0) + (String) factura.get(1) + "\n");
     document.add(paragraph1);
     paragraph1 = new Paragraph();
     paragraph1.add((String) factura.get(2) + (String) factura.get(3));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(4) + (String) factura.get(5));
     document.add(paragraph1);
     paragraph1 = new Paragraph();
     paragraph1.add((String) factura.get(6) + (String) factura.get(7) + "\n\n");
     document.add(paragraph1);
     //CUERPO FACTURA
     paragraph1 = new Paragraph();
     paragraph1.add((String) factura.get(8));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(9));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(10));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(11));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(12));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(13));
     document.add(paragraph1);
     ///////////////////
     paragraph1 = new Paragraph();
     paragraph1.add((String) factura.get(14));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(15));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(16));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(17));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(18));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(19) + "\n\n");
     document.add(paragraph1);
     /////////////////////////////
     paragraph1 = new Paragraph();
     paragraph1.add((String) factura.get(20));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(21));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(22));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(23));
     document.add(paragraph1);
     ////////////////////////////
     paragraph1 = new Paragraph();
     paragraph1.add((String) factura.get(24));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(25));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(26));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(27));
     document.add(paragraph1);
     ///////////////////////////
     paragraph1 = new Paragraph();
     paragraph1.add((String) factura.get(28));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(29));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(30));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(31));
     document.add(paragraph1);
     ////////////////////////////
     paragraph1 = new Paragraph();
     paragraph1.add((String) factura.get(36));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(37) + "\n\n");
     document.add(paragraph1);
     ////////////////////////////
     paragraph1 = new Paragraph();
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(32));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(38));
     document.add(paragraph1);
     ////////////////////////////
     paragraph1 = new Paragraph();
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(33));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add("0.0");
     document.add(paragraph1);
     ////////////////////////////
     paragraph1 = new Paragraph();
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(34));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add("0.0");
     document.add(paragraph1);
     ////////////////////////////
     paragraph1 = new Paragraph();
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(35));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(38));
     document.add(paragraph1);
     // Closing the document       
     document.close();
     }*/

    /* public void imprimirRecibo(ArrayList factura) throws FileNotFoundException, DocumentException {
     // Creating a PdfWriter       
     String dest = "C:\\Users\\WilyAndy\\Documents\\ProyectoAP\\recibo.pdf";
     // Creating a PdfDocument       
     PdfDocument pdf = new PdfDocument();
     // Creating a Document        
     Document document = new Document();
     PdfWriter.getInstance(document, new FileOutputStream(new File(dest)));
     document.open();
     //CABECERA
     Font fuente = new Font();
     fuente.setSize(25);
     Paragraph paragraph1 = new Paragraph("RECIBO DE PAGO\n\n", fuente);
     paragraph1.setAlignment(Element.ALIGN_CENTER);
     // paragraph1.add(Chunk.TABBING);paragraph1.add(Chunk.TABBING);
     //  paragraph1.add("RECIBO DE PAGO");
     document.add(paragraph1);

     ///
     paragraph1 = new Paragraph();
     paragraph1.add((String) factura.get(0) + (String) factura.get(1) + "\n");
     document.add(paragraph1);
     paragraph1 = new Paragraph();
     paragraph1.add((String) factura.get(2) + (String) factura.get(3));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(4) + (String) factura.get(5));
     document.add(paragraph1);
     paragraph1 = new Paragraph();
     paragraph1.add((String) factura.get(6) + (String) factura.get(7) + "\n\n");
     document.add(paragraph1);
     //CUERPO FACTURA
     paragraph1 = new Paragraph();
     paragraph1.add((String) factura.get(8));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(9));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(10));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(11));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(12));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(13));
     document.add(paragraph1);
     ///////////////////
     paragraph1 = new Paragraph();
     paragraph1.add((String) factura.get(14));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(15));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(16));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(17));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(18));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(19) + "\n\n");
     document.add(paragraph1);
     /////////////////////////////
     paragraph1 = new Paragraph();
     paragraph1.add((String) factura.get(20));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(21));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(22));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(23));
     document.add(paragraph1);
     ////////////////////////////
     paragraph1 = new Paragraph();
     paragraph1.add((String) factura.get(24));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(25));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(26));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(27));
     document.add(paragraph1);
     ///////////////////////////
     paragraph1 = new Paragraph();
     paragraph1.add((String) factura.get(28));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(29));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(30));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(31));
     document.add(paragraph1);
     ////////////////////////////
     paragraph1 = new Paragraph();
     paragraph1.add((String) factura.get(36));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(37) + "\n\n");
     document.add(paragraph1);
     ////////////////////////////
     paragraph1 = new Paragraph();
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(32));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(38));
     document.add(paragraph1);
     ////////////////////////////
     paragraph1 = new Paragraph();
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(33));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add("0.0");
     document.add(paragraph1);
     ////////////////////////////
     paragraph1 = new Paragraph();
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(34));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add("0.0");
     document.add(paragraph1);
     ////////////////////////////
     paragraph1 = new Paragraph();
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(35));
     paragraph1.add(Chunk.TABBING);
     paragraph1.add(Chunk.TABBING);
     paragraph1.add((String) factura.get(38));
     document.add(paragraph1);
     // Closing the document       
     document.close();
     }*/
}
