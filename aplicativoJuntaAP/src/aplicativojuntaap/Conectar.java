/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicativojuntaap;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author USUARIO
 */

public class Conectar {
    private String url = "jdbc:mysql://localhost:3306/proyecto_agua?autoReconnect=true&useSSL=false";
    private String driver = "com.mysql.jdbc.Driver";
    //private  String schema = "grafos";
    private String usuarioRoot = "root";
    private String passRoot = "12345";    
    public Connection getConexion() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuarioRoot, passRoot);
            if (con != null) {
               System.out.println("conexion exitosa");
            } else {
                System.out.println("Fallo en la conexion");
            }
        } catch (Exception e) {
            System.out.println("error: " + e);
            System.out.println("Fallo en la conexion");
        }
        return con;
    }
}
