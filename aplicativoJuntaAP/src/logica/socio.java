/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author USUARIO
 */
public class socio {
    private int codigo;
    private int numMedidor;
    private String nombre;
    private double consumoI;
    private String cedula;
    private String telefono;
    private String correo;


     public socio(int codigo, int numMedidor, String nombre, String cedula, String telefono, String correo, Double consumoI) {
        this.codigo = codigo;
        this.numMedidor = numMedidor;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.consumoI = consumoI;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the numMedidor
     */
    public int getNumMedidor() {
        return numMedidor;
    }

    /**
     * @param numMedidor the numMedidor to set
     */
    public void setNumMedidor(int numMedidor) {
        this.numMedidor = numMedidor;
    }

    /**
     * @return the consumoI
     */
    public double getConsumoI() {
        return consumoI;
    }

    /**
     * @param consumoI the consumoI to set
     */
    public void setConsumoI(double consumoI) {
        this.consumoI = consumoI;
    }

    
    
}
