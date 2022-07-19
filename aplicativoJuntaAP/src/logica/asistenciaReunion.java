/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Kami Osita Bebe
 */
public class asistenciaReunion {

    private int idSocio;
    private String fecha;
    private int tipoAsistencia;
    private int pago;

    public asistenciaReunion(int idSocio, String fecha, int tipoAsistencia, int pago) {
        this.idSocio = idSocio;
        this.fecha = fecha;
        this.tipoAsistencia = tipoAsistencia;
        this.pago = pago;
    }
    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTipoAsistencia() {
        return tipoAsistencia;
    }

    public void setTipoAsistencia(int tipoAsistencia) {
        this.tipoAsistencia = tipoAsistencia;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

}
